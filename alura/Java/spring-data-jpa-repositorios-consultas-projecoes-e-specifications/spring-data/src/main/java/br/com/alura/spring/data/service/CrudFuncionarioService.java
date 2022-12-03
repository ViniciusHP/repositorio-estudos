package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;
import br.com.alura.spring.data.service.abstractions.CrudServiceAbstract;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CrudFuncionarioService extends CrudServiceAbstract {

    private SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

    public CrudFuncionarioService() {
        super("Qual ação de Funcionário deseja executar?");
    }

    @Override
    protected void salvar(ScannerWrapper scanner) {
        Funcionario funcionario = lerInformacoesFuncionario(scanner);
        funcionarioRepository.save(funcionario);

        System.out.println("Funcionário salvo com sucesso!");
    }

    @Override
    protected void atualizar(ScannerWrapper scanner) {
        System.out.println("Informe o id do funcionario: ");
        long id = scanner.nextLong();
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

        if(funcionarioOptional.isEmpty()) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        Funcionario novosDadosFuncionario = lerInformacoesFuncionario(scanner);
        novosDadosFuncionario.setId(id);
        funcionarioRepository.save(novosDadosFuncionario);
        System.out.println("Os dados do funcionário foram atualizados!");
    }

    @Override
    protected void visualizar() {
        Iterable<Funcionario> todosFuncionarios = funcionarioRepository.findAll();
        todosFuncionarios.forEach(System.out::println);
    }

    @Override
    protected void deletar(ScannerWrapper scanner) {
        System.out.println("Informe id do funcionário: ");
        long id = scanner.nextLong();
        funcionarioRepository.deleteById(id);
        System.out.println("Funcionário deletado.");
    }

    private Funcionario lerInformacoesFuncionario(ScannerWrapper scanner) {
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o cpf: ");
        String cpf = scanner.nextLine();

        System.out.println("Informe o salário: ");
        BigDecimal salario = scanner.nextBigDecimal();

        System.out.println("Informe a data de contratação no formato 'dd/MM/yyyy': ");
        String strDataContratacao = scanner.nextLine();
        LocalDate dataContratacao = LocalDate.now();

        try {
            Date data = dt.parse(strDataContratacao);
            dataContratacao = Instant.ofEpochMilli(data.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Informe id do cargo ocupado: ");
        int cargoId = scanner.nextInt();

        System.out.println("Informe os ids das unidades de trabalho (ou 0 para finalizar): ");
        boolean continuarLendoUnidadesDeTrabalho = true;
        List<Long> chavesUT = new ArrayList<>();
        while(continuarLendoUnidadesDeTrabalho) {
            long ut = scanner.nextLong();

            if(ut > 0) {
                chavesUT.add(ut);
            } else {
                continuarLendoUnidadesDeTrabalho = false;
            }
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        funcionario.setCargo(cargoRepository.findById(cargoId).orElse(null));

        Iterable<UnidadeDeTrabalho> utIterator = unidadeDeTrabalhoRepository.findAllById(chavesUT);
        List<UnidadeDeTrabalho> unidadesDeTrabalho = StreamSupport.stream(utIterator.spliterator(), false)
                .collect(Collectors.toList());
        funcionario.setUnidadesDeTrabalho(unidadesDeTrabalho);

        return funcionario;
    }
}

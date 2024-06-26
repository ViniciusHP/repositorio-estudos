package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos-com-status")
    List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN p.user u
            WHERE u.username = :username
    """)
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN p.user u
            WHERE u.username = :username AND p.status = :status
    """)
    List<Pedido> findAllByStatusEUsuario(@Param("status") StatusPedido status, @Param("username") String username);
}

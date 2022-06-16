# Inicialização do repositório

```bash
$ git init
```

Repositório sem working tree:

```bash
$ git init --bare
```

# Estado do repositório

```bash
$ git status
```

# Configuração informações pessoais

Configuração local:

```bash
$ git config --local user.name "Meu Nome"
$ git config --local user.email "seu@email.aqui"
```

Configuração global:

```bash
$ git config --global user.name "Meu Nome"
$ git config --global user.email "seu@email.aqui"
```

# Adicionar alterações no git

Arquivo específico:

```bash
$ git add <caminho-para-o-arquivo>

$ git add index.html
```

Todos arquivos:

```bash
$ git add .
```

# Parando o monitoramento de um arquivo

```bash
$ git rm --cache <caminho-para-o-arquivo>

$ git rm --cache index.html
```

# Unir as alterações adicionadas anteriormente

```bash
$ git commit -m "Mensagem do que foi feito"
```

# Histórico de alterações

```bash
$ git log
```

Única linha:

```bash
$ git log --oneline
```

Todas informações:

```bash
$ git log -p
```

Linhas:

```bash
$ git log --graph
```

No Formato especificado:

```bash
$ git log --pretty="format:%h %s"
```

# Repositórios remotos

Listando:

```bash
$ git remote -v
```

Adicionando:

```bash
$ git remote add <nome-repositorio> <caminho-repositorio>

$ git remote add local C:/Users/seu-usuario/servidor>
```

Renomeando:

```bash
$ git remote rename <nome-antigo> <nome-novo>

$ git remote rename origin local
```

Enviando modificações:

```bash
git push <nome-repositorio> <nome-branch>

git push local master
```

Enviando modificações com atalho:

```bash
git push -u origin master
```

Trazendo modificações:

```bash
git pull <nome-repositorio> <nome-branch>

git pull local master
```

# Clonando repositório

```bash
$ git clone <caminho-repositorio> <nome-da-pasta-que-sera-criada>

$ git clone C:/Users/seu-usuario/servidor projeto
```

# Ramificações

Listagem:

```bash
$ git branch
```

Criando nova ramificação:

```bash
$ git branch <nome-ramificação>

$ git branch titulo
```

Mudando para ramificação:

```bash
$ git checkout <nome-ramificação>

$ git checkout titulo
```

Criando e mudando para ramificação:

```bash
$ git checkout -b <nome-ramificação>

$ git checkout -b titulo
```

# Unindo branches

Recebendo alterações de outra branch na branch atual:

```bash
$ git merge <outra-branch>

$ git merge titulo
```

Recebendo os commits de outra branch:

```bash
$ git rebase <outra-branch>

$ git rebase titulo
```

# Desfazendo alterações

O que foi alterado mas não adicionado:

```bash
$ git checkout -- <caminho-arquivo>

$ git checkout -- index.html
```

O que foi alterado e adicionado no git:

```bash
$ git reset HEAD <caminho-arquivo>

$ git reset HEAD index.html
```

Alterações feitas por commit:

```bash
$ git revert <hash-do-commit>
```

# Guardando alterações localmente

Guarda as alterações:

```bash
$ git stash
```
Listagem:

```bash
$ git stash list
```

Obtém lista 0:

```bash
$ git stash apply 0
```

Remove lista temporária:

```bash
$ git stash drop
```

Obtém os dados da última lista e a remove:
```bash
$ git stash pop
```

# Diferenças

Entre dois commits:

```bash
$ git diff ea539b3..6ca12ac
```

O que foi alterado mas não foi adicionado:

```bash
git diff
```

# Tag

Criando:

```bash
$ git tag -a <nome-tag> -m "Mensagem da tag"

$ git tag -a v0.1.0 -m "Lançado a primeira (BETA) versão da aplicação"
```

Listagem:

```bash
$ git tag
```

Enviando para repositório remoto

```bash
$ git push <nome-repositorio> <nome-tag>

$ git push origin v0.1.0
```

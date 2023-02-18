# logica-computacional-ep1

Primeiro Exercíco-Programa da Disciplina de Lógica Computacional

## Instalação

Para executar o projeto, você deve ter o `Clojure` e `Lein` instalados em seu computador. Os passos de instalação podem ser encontrados nas páginas oficiais:

[Como instalar Clojure](https://clojure.org/guides/install_clojure)

[Como instalar Lein](https://leiningen.org)


## Como executar

No arquivo "matrix.csv", preencher com a matriz que representa a relação que deseja obter o fecho reflexivo e transitivo.

Utilizar o comando:
```
lein run logica-computacional-ep1.core "matrix.csv" "reflexive_transitive_closure.csv"
```

O fecho reflexivo e transitivo será representado na matriz em "reflexive_transitive_closure.csv".

Você pode executar os testes EndToEnd pelo comando
```
lein test
```

Caso queira incluir novos tests, insira um novo arquivo de entrada na pasta `test/logica_computacional_ep1/data/input` com o nome matrix`{N}`.csv e um arquivo de saída em `test/logica_computacional_ep1/data/expected_output` nomeado expected_output`{N}`.csv com a saída esperada. Execute o comando de teste novamente e verifique se o teste passa para seu caso.

## Relatório

Com esse projeto foi possível entender melhor a teoria de conjuntos em respeito as relações (...)
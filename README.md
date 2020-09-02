# Elevador-consumer
O projeto tem por objetivo efetuar a leitura de um arquivo.json e dada as informações do arquivo são gerados derterminados valores de saída.
## Enunciado
Suponha que a administração do prédio 99a da Tecnopuc, com 16 andares e cinco elevadores, denominados A, B, C, D e E, nos convidou a aperfeiçoar o sistema de controle dos elevadores. Depois de realizado um levantamento no qual cada usuário respondia:
## Questões
- a) O elevador que utiliza com mais frequência (A, B, C, D ou E)
- b) O andar ao qual se dirigia (0 a 15)
- c) O período que utilizava o elevador – M: Matutino; V: Vespertino; N: Noturno
### exemplo de arquivo
```
[
  {
      "andar": 8,
      "elevador": "B",
      "turno": "V"
  },{
      "andar": 4,
      "elevador": "D",
      "turno": "M"
  }
]
```
## Dados de Saída
Considerando que este possa evoluir para um sistema dinâmico, escreva o código que nos ajude a extrair as seguintes informações:
- a) Qual é o andar menos utilizado pelos usuários;
```
Andar menos utilizado!
[8, 0, 5, 6, 7, 9, 10, 11, 12, 14, 2, 3, 13, 15, 1, 4]
```
- b) Qual é o elevador mais frequentado e o período que se encontra maior fluxo;
```
Elevador mais frequentado!
[C, A, B, D, E]

Periodo de maior fluxo do elevador mais frequentado!
[M, V, N]

```
- c) Qual é o elevador menos frequentado e o período que se encontra menor fluxo;
```
Elevador menos frequentado!
[D, E, B, A, C]

Periodo de menor fluxo do elevador menos frequentado!
[N, V, M]
```
- d) Qual o período de maior utilização do conjunto de elevadores;
```
Periodo de maior utilização de todos os elevadores!
[M, V, N]
```
- e) Qual o percentual de uso de cada elevador com relação a todos os serviços prestados;
```
Percentual de Uso elevador A!
34.782608%

 Percentual de Uso elevador B!
17.391304%

 Percentual de Uso elevador C!
39.130436%

 Percentual de Uso elevador D!
4.347826%

 Percentual de Uso elevador E!
4.347826%
```
## Tecnologias
* Linguagem Java
* Gradle

## Requisitos
```
Java 11
biblioteca gson versão 2.8.6
```
## Execução
Para efetuar teste em ambiente local basta efetur um clone deste repositório:
`
git clone ....
`
e com o uso de alguma IDE como Eclipse ou Intellij executar o a metodo main contido na classe Main


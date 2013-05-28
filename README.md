Computação Evolutiva - Trabalho #1
=========

Implementar aplicação, usando algoritmos Genéticos para
a resolução do problema de geração da grade de
horários, minimizando as Soft Constraints e respeitando
as Hard Constraitns. Realizar comparações com
diferentes tamanhos de população, taxa de cruzamento e
taxa de mutação.

Hard Constraints
--------
* Todas as disciplinas da grade curricular contempladas.
* Docente alocado em duas turmas ao mesmo tempo.
* Turmas sem docente alocado.
* Disponibilidade suficiente de docentes para as turmas e
disciplinas que ministram.

Soft Constraints
--------
* Eliminar o máximo de “janelas” de docentes.
* Permitir a geminação de disciplinas em slots de tempo próximos.
* Evitar “janelas” na alocação das disciplinas em um mesmo dia.

Definiu-se o seguinte cronograma para o desenvolvimento das atividades, as quais devem ser carregadas 'a medida do desenvolvimento das mesmas no moodle da disciplina :

* Estrutura de dados e função de fitness 28/05
* Interface gráfica permitindo parametrização 04/06
* Implementação e escolha de operadores 11/06
* Análise de resultados 18/06
* Relatório e escrita de artigo 02/07

Estrutura de Dados
------
horario[n,m] = i //aponta para docente
docente[i] = j //aponta para disciplina
disciplina[j] = int, default 0. //numero de docentes lecionando a disciplina

Exemplo:
```c
horario = 
[
[1,2,3], 
[0, 1, 2],
[1,2,1],
[3,4,1],
];

docente[0] = 1;
docente[1] = 0;
docente[2] = 3;
docente[3] = 2;
docente[4] = 3;

disciplina[0] = 1; //matemática
disciplina[1] = 1; // biologia
disciplina[2] = 1; //química
disciplina[3] = 2; // física
disciplina[4] = 0; //literatura - nenhum docente dando aula.
```

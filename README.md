## Trabalho de Paradigmas de programação
### Cadastramento de atividades usando spring boot e react-js com mongoDB

Nesse projeto, é implementado um sistema de cadastramento de atividades acadêmicas para determinado aluno em um bando de dados. O software permite quatro tipos de utilização, sendo elas:
1. Cadastramento de um aluno  
2. Cadastramento de atividade para o aluno 
3. Listagem de alunos/aluno
4. Gerar um relatório em PDF de atividades de um aluno 

Todo aluno possui 5 atributos pré-definidos que são id(gerado pelo próprio banco de dados), nome, matricula(sendo única para cada aluno), curso e uma lista de atividades.

No campo de atividades de um aluno, podemos ter várias disciplinas diferentes, onde cada uma é composta por um conjunto de atividades. Cada atividade possui 4 atributos: Nome, Nota, Peso e Observações. No seguinte formato:

`	atividades : {
			disciplina : [
					{
							nome:string,
							peso: float,
							nota: float,
							observacoes: string
					}
				] 
}
`




#language:pt
#coding: utf-8
#  Funcionalidade: Descreve qual o objetivo do swite de testes
#  Contexto: São "steps" que são comuns a todos os testes presentes na funcionalidade
#  Cenário: Descreve o intuito e o que se espera do caso de teste
#  Dado: especifica o contexto
#  Quando: especifica uma ação de teste que deve ser realizada
#  E: concatena ações a serem realizadas
#  Then: apresenta o resultado esperado do teste
#  As anotações representadas por "@NomeDaTag" é útil na seleção dos casos de teste a serem utilizados

@EXAMPLES
Funcionalidade: "Descrição da funcionalidade a ser testada"
  Como um usuário
  Eu quero validar alguma funcionalidade

  Contexto:
#    Dado que acesso o site de exemplo

  @Examples_01 @validado
#  Cenário: Deve acessar o site de exemplo

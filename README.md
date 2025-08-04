Projeto desenvolvido como parte da avaliação da disciplina de Física na Universidade Estadual do Paraná (UNESPAR).

Este projeto é uma aplicação Java com interface gráfica (Swing) que permite visualizar e calcular o trabalho necessário para trazer uma carga pontual até o centro de um sistema composto por múltiplas cargas elétricas fixas. A aplicação simula a situação estudada no problema 44 da Figura 24-48, envolvendo conceitos fundamentais de eletrostática.

Funcionalidades:
Interface gráfica interativa e didática, com visualização em tempo real das cargas no plano cartesiano.

Permite a entrada de:

Valor da carga elétrica (em múltiplos de 𝑒);

Posição da carga (coordenadas x e y em pixels, relativas ao painel gráfico);

Várias cargas podem ser adicionadas dinamicamente.

A aplicação fornece:

Visualização gráfica da disposição das cargas ao redor do centro do sistema;

Cálculo automático do potencial elétrico total gerado pelas cargas fixas no centro do sistema;

Cálculo do trabalho necessário para trazer uma carga de valor fixo +6e desde o infinito até o centro do sistema;

Resultados exibidos de forma clara e organizada em uma área de texto no painel inferior;

Mensagens informativas em caso de entrada inválida;

Botões adicionais para limpar os campos de entrada e adicionar novas cargas com facilidade.

Lógica de Calculo:

Sete partículas carregadas estão fixas em posições que formam um quadrado de lado 4,0 cm. As cargas estão distribuídas nos vértices, meios dos lados e no centro do quadrado. Deseja-se calcular o trabalho necessário para trazer uma carga de +6e do infinito até o centro do quadrado.

Conceitos Envolvidos
O trabalho W realizado por forças externas para trazer uma carga q até um ponto de potencial elétrico V é dado por:

W = q ⋅ V

O potencial total no centro é a soma dos potenciais produzidos pelas cargas fixas:


V=∑ k⋅qi/ri
​
Onde:

𝑘 =8,99×10^9 Nm²/C²
qi = valor da carga i
ri = distância da carga i ao centro

 Dados do Problema
Lado do quadrado: 

L=0,04m

Cargas e posições (visualmente):

Vértices (distância  𝑟 = 𝐿/2 ≈ 0,0283m

𝑞1 = −𝑒, q2 = +3e, q 6 = +e.

Meios dos lados (distância  r = L/2 = 0,02m):

q3 =+2e,  q4 = −2e,  q5 = +3e.

Centro:  q0 =+3e (não contribui para o potencial sobre a carga que chega)

 Cálculo dos Potenciais
Potencial gerado pelas cargas nos vértices:

𝑉diag = 𝑘 ⋅ (−𝑒 + 3𝑒 + 𝑒)/0,0283 = 𝑘 ⋅ 3𝑒/0,0283 ≈ 1,52V 

Potencial gerado pelas cargas nos meios dos lados:

V meios = k ⋅  0,02/(2e−2e+3e) = k ⋅  0,02/3e ≈ 2,16V

Potencial total no centro:


V total = 1,52 + 2,16 = 3,68V

Cálculo do Trabalho

Carga a ser trazida: 

q = +6e = 6 ⋅ 1,6 × 10 ^−19C

W = q ⋅ V = 6 ⋅ 1,6 × 10^ −19 ⋅ 3,68 ≈ 3,53 × 10 ^−18J

 Resultado Final:
O trabalho necessário para trazer a carga +6e do infinito até o centro do quadrado é aproximadamente:

3,5 × 10 ^−18J

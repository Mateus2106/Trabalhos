<html>

	<head>
		<title>Calculadora IMC</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>

	<body>

		<header>
			<h2>Calculadora de IMC</h2>
		</header>

		<aside id="esquerda">
			<h2>O IMC nem sempre está certo</h2>
			<p>Infelizmente, a medida de IMC nem sempre representa a realidade. Por exemplo, o músculo é muito mais pesado que a gordura. Logo, um halterofilista terá um IMC muito alto, mas isso não se reflete em obesidade, já que a maior parte de sua massa corporal é formada por musculatura.</p>
			<p>É importante levar em conta que a massa corporal é formada por água, gordura, músculos e ossos, e tudo isso precisa ser bem avaliado para medir a saúde de alguém corretamente. Por isso, é de extrema importância consultar um especialista para que ele possa fazer a análise do IMC junto com outros índices e medidas usados para entender a composição corporal.</p>
		</aside>

		<main>
			<?php
				$imc = 0;
				function redirecionar ()
				{
					header("refresh:10; url=index.html");
				}

				if(!empty($_POST["peso"]) and !empty($_POST["altura"]))
				{
					$imc = $_POST["peso"] / ((pow($_POST["altura"],2))/10000);
				}
				else
				{
					redirecionar();
				}
			?>

			<p>Seu IMC é <?php echo number_format($imc,3);?></p>
			<table id="tabela">
		      <tr>
		        <th id="tabelaL">IMC</th>
		        <th id="tabelaL">Classificação</th>
		      </tr>
		      <tr id="primeiro">
		        <td id="tabelaL">Abaixo de 18,5 </td>
		        <td id="tabelaL">Abaixo do peso</td>
		      </tr>
		      <tr id="segundo">
		        <td id="tabelaL">Entre 18,5 e 24,9</td>
		        <td id="tabelaL">Peso ideal</td>
		      </tr>
		      <tr id="terceiro">
		        <td id="tabelaL">Entre 25 e 29,8</td>
		        <td id="tabelaL">Levemente acima do peso</td>
		      </tr>
		      <tr id="quarto">
		        <td id="tabelaL">Entre 30 e 34,9</td>
		        <td id="tabelaL">Obesidade grau I</td>
		      </tr>
		      <tr id="quinto">
		        <td id="tabelaL">Entre 35 e 39,9</td>
		        <td id="tabelaL">Obesidade grau II (Severa)</td>
		      </tr>
		      <tr id="sexto">
		        <td id="tabelaL">Acima de 40</td>
		        <td id="tabelaL">Obesidade grau III (Mórbida)</td>
		      </tr>
		    </table>

		    <script type="text/javascript">
	      		var imc = <?php echo $imc;?>;
		        
		        if(imc == 0)
		        {
		        	document.write("<p><?php echo "Você não digitou em todos os campos!!<br>Você será redirecionado para a página principal em 10 segundos!!";?></p><h2>Cálculo do IMC</h2><p>O IMC é calculado dividindo o peso pela altura elevada ao quadrado. Ou seja, de forma mais simples, você multiplica sua altura por ela mesma e depois divide seu peso pelo resultado da última conta.</p><p>Por exemplo, uma pessoa com 1,70 m e 70 kg fará o seguinte cálculo:</p><ul><li>Altura multiplicada por ela mesma: 1,70 x 1,70 = 2,89</li><li>Peso dividido pelo quadrado da altura: 70 / 2,89 = 24,22</li></ul><p>Logo, essa pessoa tem IMC de 24.</p>")
		        }

		        else if (imc < 18.5) 
		        {
		          document.getElementById("primeiro").style.color = "blue";
		          document.write("<h2>Abaixo do peso</h2><p>Ao perder muito peso em um curto período de tempo, é preciso investigar a causa do emagrecimento. A melhor maneira é procurando um médico para a realização de exames. No caso dos transtornos alimentares, como bulimia e anorexia nervosa, ainda é indicado o acompanhamento terapêutico. O estresse e a ansiedade também podem afetar a perda de peso, sendo indicadores de que o corpo precisa de tratamento. Estar abaixo do peso pode causar:</p><ul><li>Unhas e cabelos secos e quebradiços</li><li>Pele seca</li><li>Incapacidade de se concentrar</li><li>Esquecimento</li><li>Exaustão</li><li>Irritabilidade</li><li>Perda de apetite</li><li>Dor nas articulações</li><li>Vertigem</li><li>Sensação de desmaio</li><li>Dores de cabeça</li></ul><p>Para ter um ganho de peso saudável, não se deve comer somente muitos alimentos calóricos e sim priorizar alguns alimentos com boa quantidade calórica, mas ricos em nutrientes benéficos e com pouca quantidade de gordura saturada (de origem animal) e gordura trans (de industrializados). Confira algumas estratégias interessantes que podem te ajudar nesse processo:</p><ul><li>Alimentos ricos em proteína são grandes aliados: dê preferência às carnes magras (alcatra, filé mignon, maminha, fraldinha) , frango e principalmente peixes e ovos, além de leite e queijos brancos como ricota e minas</li><li>Aposte nas gorduras boas: amendoim, nozes, amêndoa, avelã, castanhas, azeite de oliva, linhaça e abacate</li><li>Aumente o consumo de pães, bolos, massas, mandioca, batata, milho e cereais (arroz, farinha de trigo, fubá, aveia), lembrando sempre de optar pelas versões integrais</li><li>Evite alimentos nas versões diet e light, baixo teor de gorduras, calorias reduzidas</li></ul>");
		        }

		        else if (imc <= 18.5 || imc <= 24.9)
		        {
		          document.getElementById("segundo").style.color = "blue";
		          document.write("<h2>Peso ideal</h2><p>Estar dentro da faixa de peso normal é significa ter um peso considerado adequado para sua altura, idade e sexo, de acordo com as faixas do IMC - momento de fazer a manutenção do peso Para manter o peso é importante manter uma dieta balanceada (não basta alimentos corretos, mas também quantidades corretas) para seu organismo. Devem ser avaliados peso, idade, composição corporal, presença de doenças e/ou comorbidades. Pontos importantes para manter o peso:</p><ul><li>Não existe alimento 100% bom ou 100% ruim. Varie ao máximo o seu cardápio e não elimine completamente nenhum tipo de alimento. O equilíbrio entre a quantidade e a freqüência com a qual você consome refeições mais calóricas é a garantia do seu sucesso</li><li>Estabeleça uma rotina alimentar</li><li>Analise os rótulos dos alimentos. Muitas vezes, os alimentos light contêm uma pequena diferença na quantidade calórica, que nem compensa a troca</li><li>Praticar atividades físicas de forma regular</li><li>Descanse e durma o suficiente</li><li>Para ter uma alimentação saudável é importante que ela seja muito variada e conte com todos os grupos alimentares. Lembrando que produtos alimentares ultraprocessados, como embutidos, bolachas recheadas, entre outros, não entram na conta</li><li>Aumentar a ingestão de líquidos no dia (mínimo de 2L de água)</li></ul>");
		        }

		        else if (imc <= 25 || imc <= 29.9)
		        {
		          document.getElementById("terceiro").style.color = "blue";
		          document.write("<h2>Levemente acima do peso</h2><p>O sobrepeso é uma condição em que a pessoa pesa mais do que é considerado adequado para aquela altura, idade e sexo. O sedentarismo e os maus hábitos alimentares levam ao aumento dessa parcela de indivíduos com sobrepeso a cada ano. Essa faixa, se analisada junto com outras medidas e índices, pode demonstrar um risco maior de doenças como diabetes tipo 2, dislipidemia (com colesterol HDL baixo e triglicérides altos), ácido úrico aumentado, hipertensão, entre outras.</p><p>O tratamento para o sobrepeso depende de sua causa. Contudo, manter hábitos alimentares saudáveis e praticar atividades físicas são bons aliados contra o excesso de peso. Em casos mais graves, a cirurgia bariátrica pode ser uma alternativa. Dependendo da causa do excesso de peso, pode ser necessária a consulta com o psicólogo ou psiquiatra. Os remédios para emagrecer, quando bem indicados e sempre com acompanhamento médico, podem ser úteis dependendo do caso.</p>");
		        }

		        else if (imc <= 30 || imc <= 34.9) 
		        {
		          document.getElementById("quarto").style.color = "blue";
		          document.write("<h2>Obesidade grau I</h2><p>O tratamento é realizado através de dieta apropriada com avaliação médica em conjunto com a prática de exercícios, desde que o paciente seja avaliado e liberado pelo médico. Além disso, é preciso que o paciente realize as atividades com o acompanhamento de um profissional de educação física. Em alguns casos avaliados pelo médico, pode-se fazer o uso de remédios para emagrecer para ajudar no controle do peso.</p><p>A cirurgia bariátrica também pode ser destinada ao tratamento da obesidade grau 1 que é acompanhada de outras doenças cuja obesidade é um agravante ou doenças associadas ao excesso de gordura corporal. Mas neste grau de obesidade, os outros meios do controle de peso são priorizados e a bariátrica só passa a ser considerada quando as alternativas primárias são comprovadamente ineficazes. Pacientes que têm IMC abaixo de 35, sem doenças associadas, devem sem dúvidas tentar o tratamento clínico antes, com chances de conseguir resultados razoáveis.</p>");
		        }

		        else if (imc <= 35 || imc <= 39.9) 
		        {
		          document.getElementById("quinto").style.color = "blue";
		          document.write("<h2>Obesidade grau II</h2><p>Os riscos associados à obesidade de grau II são mais acentuados. Entre eles, estão a esteatose hepática, doenças articulares, hipertensão, diabetes mellitus, síndrome metabólica, cânceres, infarto agudo do miocárdio e acidente vascular cerebral, lembrando que estes dois últimos são as principais causas de morte no Brasil e no mundo.</p><p>O tratamento desse quadro é dado através de mudanças no estilo de vida, associado ao tratamento multiprofissional com nutricionista, psicólogo e médico. No caso da obesidade grau II, o uso de medicações para a perda de peso também é um método que pode ser proposto diante de avaliação e acompanhamento médico.</p><p>Já a cirurgia bariátrica costuma ser indicada para obesidade grau II quando não há resultados no tratamento convencional nos últimos dois anos e quando está associada a outras comorbidades, ou seja, outras doenças que podem vir associadas ao excesso de peso, que levam a redução da expectativa e da qualidade de vida.</p>");
		        }

		        else
		        {
		          document.getElementById("sexto").style.color = "blue";
		          document.write("<h2>Obesidade grau III</h2><p>Entre as patologias associadas à obesidade grau 3, estão os distúrbios hormonais, cardiopatias, morte súbita, dermatites, osteoporose, hipertensão, hepatopatias e insuficiência venosa. Porém, segundo a Organização Mundial de Saúde (OMS), a obesidade de grau III é a principal causa de morte evitável do mundo.</p><p>A associação de reeducação alimentar e atividade física têm melhores resultados a curto e médio prazo, porém, muitas vezes, em pacientes com obesidade grau III, a atividade física acaba sendo bastante restrita, dependendo do grau de excesso de peso e das artropatias associadas.</p><p>Nesses casos, esses pacientes podem optar por fazer a cirurgia de redução de estômago para controlar o peso e sair da obesidade. Existem quatro técnicas diferentes de cirurgia bariátrica para obesidade reconhecidas pelo Conselho Federal de Medicina (CFM): Banda Gástrica Ajustável, Gastrectomia Vertical, Bypass Gástrico e Derivação Bileopancreática. A escolha da cirurgia dependerá do quadro do paciente, do grau de obesidade e das doenças relacionadas.</p>");
		        }
     		</script>
		</main>
		
		<aside id="direita">
			<h2>Outros tipos de medidas</h2>
			<p>Existem alguns outros índices e medidas que podem ser usados, como:</p>
			<p><b>Medidas antropométricas:</b> mede a circunferência e quantidade de gordura nos braços, pernas e tronco, em alguns pontos estratégicos.</p>
			<p><b>Bioimpedância:</b> estima o percentual de água, massa muscular e massa gorda do organismo</p>
			<p><b>Circunferência abdominal:</b> avalia a quantidade de gordura visceral do paciente, que é a mais perigosa.</p>
			<p><b>Relação cintura-quadril:</b> Mostra onde está o acúmulo de gordura de cada pessoas.</p>
		</aside>

      <footer>
      	<p>Copyright @ Mateus Chaves Marques</p>
      </footer>
	</body>

</html>
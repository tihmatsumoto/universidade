package servidorHash;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class servidor {
	
	private static Map<Integer, String> frases = new HashMap<>();
	
	static {
		
		frases.put (1,  "Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos – James Cameron, cineasta");
		frases.put (2,  "O sucesso normalmente vem para quem está ocupado demais para procurar por ele – Henry David Thoreau, filósofo");
		frases.put (3,  "A vida é melhor para aqueles que fazem o possível para ter o melhor – John Wooden, jogador e treinador de basquete");
		frases.put (4,  "Os empreendedores falham, em média, 3,8 vezes antes do sucesso final. O que separa os bem-sucedidos dos outros é a persistência – Lisa M. Amos, executiva");
		frases.put (5,  "Se você não está disposto a arriscar, esteja disposto a uma vida comum – Jim Rohn, empreendedor");
		frases.put (6,  "Escolha uma ideia. Faça dessa ideia a sua vida. Pense nela, sonhe com ela, viva pensando nela. Deixe cérebro, músculos, nervos, todas as partes do seu corpo serem preenchidas com essa ideia. Esse é o caminho para o sucesso – Swami Vivekananda, pensador hindu");
		frases.put (7,  "Para de perseguir o dinheiro e comece a perseguir o sucesso – Tony Hsieh, empreendedor");
		frases.put (8,  "Todos os seus sonhos podem se tornar realidade se você tem coragem para persegui-los – Walt Disney, desenhista e empreendedor");
		frases.put (9,  "Ter sucesso é falhar repetidamente, mas sem perder o entusiasmo – Winston Churchill, político");
		frases.put (10,  "Sempre que você vir uma pessoa de sucesso, você sempre verá as glórias, nunca os sacrifícios que os levaram até ali – Vaibhav Shah, pensador");
		frases.put (11,  "Sucesso? Eu não sei o que isso significa. Eu sou feliz. A definição de sucesso varia de pessoa para pessoa Para mim, sucesso é paz anterior – Denzel Washington, ator");
		frases.put (12,  "Oportunidades não surgem. É você que as cria – Chris Grosser, fotógrafo");
		frases.put (13,  "Não tente ser uma pessoa de sucesso. Em vez disso, seja uma pessoa de valor – Albert Einstein, físico");
		frases.put (14,  "Não é o mais forte que sobrevive, nem o mais inteligente. Quem sobrevive é o mais disposto à mudança – Charles Darwin, biólogo");
		frases.put (15,  "A melhor vingança é um sucesso estrondoso – Frank Sinatra, cantor");
		frases.put (16,  "Eu não falhei. Só descobri 10 mil caminhos que não eram o certo – Thomas Edison, inventor");
		frases.put (17,  "Um homem de sucesso é aquele que cria uma parede com os tijolos que jogaram nele – David Brinkley, jornalista");
		frases.put (18,  "Ninguém pode fazer você se sentir inferior sem o seu consentimento – Eleanor Roosevelt, primeira-dama dos EUA");
		frases.put (19,  "O grande segredo de uma boa vida é encontrar qual é o seu destino. E realizá-lo – Henry Ford, empreendedor");
		frases.put (20,  "Se você está atravessando um inferno, continue atravessando – Churchill");
		frases.put (21,  "O que nos parece uma provação amarga pode ser uma bênção disfarçada – Oscar Wilde, escritor");
		frases.put (22,  "A distância entre a insanidade e a genialidade é medida pelo sucesso – Bruce Feirstein, roteirista");
		frases.put (23,  "Não tenha medo de desistir do bom para perseguir o ótimo – John D. Rockefeller, empreendedor");
		frases.put (24,  "A felicidade é uma borboleta que, sempre que perseguida, parecerá inatingível; no entanto, se você for paciente, ela pode pousar no seu ombro – Nathaniel Hawthorne, escritor");
		frases.put (25,  "Se você não pode explicar algo de forma simples, então você não entendeu muito bem o que tem a dizer – Einstein");
		frases.put (26,  "Há dois tipos de pessoa que vão te dizer que você não pode fazer a diferença neste mundo: as que têm medo de tentar e as que têm medo de que você se dê bem – Ray Goforth, executivo");
		frases.put (27,  "Comece de onde você está. Use o que você tiver. Faça o que você puder – Arthur Ashe, tenista");
		frases.put (28,  "As pessoas me perguntam qual é o papel que mais gostei de interpretar. Eu sempre respondo: o próximo – Kevin Kline, ator");
		frases.put (29,  "Descobri que, quanto mais eu trabalho, mais sorte eu pareço ter – Thomas Jefferson, político");
		frases.put (30,  "O ponto de partida de qualquer conquista é o desejo – Napoleon Hill, assessor político");
		frases.put (31,  "O sucesso é a soma de pequenos esforços repetidos dia após dia – Robert Collier, escritor");
		frases.put (32,  "Todo progresso acontece fora da zona de conforto – Michael John Bobak");
		frases.put (33,  "Coragem é a resistência e o domínio do medo, não a ausência dele – Mark Twain, escritor");
		frases.put (34,  "Só evite fazer algo hoje se você quiser morrer e deixar assuntos inacabados – Pablo Picasso, pintor");
		frases.put (35,  "O único lugar em que o sucesso vem antes do trabalho é no dicionário – Vidal Sassoon, cabeleireiro");
		frases.put (36,  "Não sei qual é a chave para o sucesso, mas a chave para o fracasso é tentar agradar a todos – Bill Cosby, comediante");
		frases.put (37,  "Embora ninguém possa voltar atrás e começar tudo de novo, qualquer um pode ter um ótimo final – Carl Bard");
		frases.put (38,  "Descobri que, se você tem vontade de viver e curiosidade, dormir não é a coisa mais importante – Martha Stewart, apresentadora");
		frases.put (39,  "Daqui a vinte anos, você não terá arrependimento das coisas que fez, mas das que deixou de fazer. Por isso, veleje longe do seu porto seguro. Pegue os ventos. Explore. Sonhe. Descubra – Twain");
		frases.put (40,  "O primeiro passo rumo ao sucesso é dado quando você se recusa ao ser um refém do ambiente em que se encontra – Mark Caine, jornalista");
		frases.put (41,  "Sempre que você se encontrar do lado da maioria, é hora de parar e refletir – Twain");
		frases.put (42,  "Continue andando. Haverá a chance de você ser barrado por um obstáculo, talvez por algo que você nem espere. Mas siga, até porque eu nunca ouvi falar de ninguém que foi barrado enquanto estava parado – Charles F. Kettering, inventor");
		frases.put (43,  "Se você realmente quer algo, não espere. Ensine você mesmo a ser impaciente – Gurbaksh Chahal, empreendedor");
		frases.put (44,  "Se você quer uma mudança permanente, pare de focar no tamanho de seus problemas e comece a focar no seu tamanho! – T. Harv Eker, autor");
		frases.put (45,  "Pessoas de sucesso fazem o que pessoas mal sucedidas não querem fazer. Não queira que a vida seja mais fácil. Deseje que você seja ainda melhor – Rohn");
		frases.put (46,  "A primeira razão para o fracasso de alguém é escutar amigos, família e vizinhos – Hill");
		frases.put (47,  "O sucesso não consiste em não errar, mas não cometer os mesmos equívocos mais de uma vez – George Bernard Shaw, autor");
		frases.put (48,  "A motivação é o que faz o empreendedor começar e o hábito é o que nos faz continuar – Jim Rynn");
		frases.put (49,  "Nosso maior medo não deve ser o fracasso, mas ser bem-sucedidos em algo que não importa – Francis Chan, pastor");
		frases.put (50,  "Se você não traçou um plano para você mesmo, é possível que você caia no plano de outra pessoa. E adivinha o que ele planejou para você? Não muito – Rohn");
		frases.put (51,  "Você deve lutar mais de uma batalha para se tornar um vencedor – Margaret Thatcher, política");
		frases.put (52,  "Eu devo meu sucesso a meu hábito de respeitosamente ouvir conselhos e fazer exatamente o contrário – G. K. Chesterton, escritor");
		frases.put (53,  "Muitas das falhas da vida ocorrem quando não percebemos o quão próximos estávamos do sucesso na hora em que desistimos – Edison");
		frases.put (54,  "Quanto maior o artista, maior a dúvida. Confiança grande demais é algo destinados aos menos talentosos como um prêmio de consolação – Robert Hughes, crítico de arte");
		frases.put (55,  "Uma fórmula para o sucesso? É bem simples, na verdade: dobre a probabilidade de fracasso da sua empresa. Você pensa que a falha é um inimigo do sucesso. Mas não é, de jeito nenhum. Você pode ser desencorajado com os erros ou aprender com eles, então siga em frente e continue falhando. Erre o máximo que puder. É aí que você vai conseguir o sucesso – Thomas J. Watson, empreendedor");
		frases.put (56,  "Tenha em mente que o seu desejo em atingir o sucesso é mais importante que qualquer coisa – Abraham Lincoln, político");
		frases.put (57,  "Fique contente em agir. Deixe a fala para os outros – Baltasar Gracián, filósofo");
		frases.put (58,  "Para conquistar o sucesso, você precisa aceitar todos os desafios que vierem na sua frente. Você não pode apenas aceitar os que você preferir – Mike Gafka, palestrante");
		frases.put (59,  "O guerreiro de sucesso é um homem médio, mas com um foco apurado como um raio laser – Bruce Lee, ator");
		frases.put (60,  "A lógica pode levar de um ponto A a um ponto B. A imaginação pode levar a qualquer lugar – Einstein");
		frases.put (61,"A vida é sobre criar impacto, não uma renda – Kevin Kruse.");
		frases.put (62,"Seja o que a sua mente pode conceber e acreditar, ela pode conseguir – Napoleon Hill.");
		frases.put (63,"Esforce-se para não ser um sucesso, mas sim para ser valioso – Albert Einstein.");
		frases.put (64,"Duas estradas divergiam em uma bifurcação, e eu peguei a menos percorrida. E isso fez toda a diferença – Robert Frost.");
		frases.put (65,"Eu atribuo o meu sucesso a isso: eu nunca dei ou tomei qualquer desculpa – Florence Nightingale.");
		frases.put (66,"Você perde 100% dos tiros que não dá- Wayne Gretzky.");
		frases.put (67,"Eu perdi mais de 9 mil tiros livres em minha carreira. Eu perdi quase 300 jogos. Em 26 vezes e tive a bola do jogo e perdi. Eu falhei uma e outra vez em minha vida. E é por isso que eu consegui – Michael Jordan.");
		frases.put (68,"A coisa mais difícil é a decisão de agir, o resto é apenas tenacidade – Amelia Earhart.");
		frases.put (69,"Todo strike me aproxima do próximo home run – Babe Ruth.");
		frases.put (70,"Definir um objetivo é o ponto de partida de toda a realização – W. Clement Stone.");
		frases.put (71,"A vida não é sobre ter, e sobre dar e ser – Kevin Kruse.");
		frases.put (72,"A vida é o que acontece com você enquanto você está ocupado fazendo planos – John Lennon.");
		frases.put (73,"Nós nos tornamos aquilo que pensamos – Earl Nightingale.");
		frases.put (74,"Daqui a 20 anos você estará mais decepcionado pelas coisas que você não fez, do que pelas que fez. Então, jogue fora suas amarras, navegue para longe do porto seguro, pegue os ventos em suas velas. Explore, sonha, descubra – Mark Twain.");
		frases.put (75,"A vida é 10% do que acontece comigo e 90% de como eu reajo a isso – Charles Swindoll.");
		frases.put (76,"A forma mais comum com que as pessoas exercem o seu poder é pensar que eles não têm poder – Alice Walker.");
		frases.put (77,"A mente é tudo. Você se torna aquilo que você pensa – Buddha.");
		frases.put (78,"A melhor época para plantar uma árvore foi há 20 anos. A segunda melhor é agora – Provérbio Chinês.");
		frases.put (79,"Uma vida não examinada, não vale a pena ser vivida – Sócrates.");
		frases.put (80,"80% do sucesso aparece – Woody Allen.");
		frases.put (81,"Seu tempo é limitado, então não o gaste vivendo a vida de outra pessoa—Steve Jobs.");
		frases.put (82,"Ganhar não é tudo, mas querer ganhar é – Vince Lombardi.");
		frases.put (83,"Eu não sou um produto de minhas circunstâncias. Eu sou um produto de minhas decisões – Stephen Covey.");
		frases.put (84,"Cada criança é um artista. O problema é permanecer um artista depois que crescemos – Pablo Picasso.");
		frases.put (85,"Você nunca pode atravessar o oceano até que você tenha coragem de perder de vista a costa – Cristóvão Colombo.");
		frases.put (86,"Eu aprendi que as pessoas vão esquecer o que você disse, as pessoas vão esquecer o que você fez, mas as pessoas nunca esquecerão como você as fez sentir – Maya Angelou.");
		frases.put (87,"Ou você corre do dia, ou durante o dia você corre – Jim Rohn.");
		frases.put (88,"Se você pensa que pode, ou que não pode, você está certo – Henry Ford.");
		frases.put (89,"Os dias mais importantes na sua vida são o dia em que você nasce, e o dia em que você descobre o porquê – Mark Twain.");
		frases.put (90,"Tudo que você pode fazer, ou sonha que pode, comece. Ousadia tem genialidade, poder e magia – Johann Wolfgang von Goethe.");
		frases.put (91,"A melhor vingança é o sucesso maciço – Frank Sinatra.");
		frases.put (92,"As pessoas costumam dizer que a motivação não dura. Bem, nem o banho. É por isso que recomendamos isso diariamente – Zig Ziglar.");
		frases.put (93,"A vida encolhe ou expande em proporção com a sua coragem – Anais Nin.");
		frases.put (94,"Se você ouve uma voz dentro de você dizendo ‘você não pode pintar’, então pinte e essa voz será silenciada – Vincent Van Gogh.");
		frases.put (95,"Há apenas uma maneira de evitar críticas: não faça nada, não diga nada, e não seja nada – Aristóteles.");
		frases.put (96,"Peça, e lhes será dado; procure e encontrará; bata, e a porta será aberta para você – Jesus.");
		frases.put (97,"A única pessoa que você está destinado a se tornar é a pessoa que você decide ser – Ralph Waldo Emerson.");
		frases.put (98,"Vá na direção de seus sonhos. Viva a vida que você imaginou – Henry David Thoreau.");
		frases.put (99,"Poucas coisas podem ajudar mais um indivíduo do que colocar a responsabilidade em cima dele, e deixa-lo saber que você confia nele – Booker T. Washington.");
		frases.put (100,"Determinadas coisas capturam o seu olho, mas leve a cabo apenas aquelas que capturam seu coração – Provérbio indiano.");
		frases.put (101,"Acredite que você pode e você vai chegar lá – Theodore Roosevelt.");
		frases.put (102,"Tudo o que você sempre quis está do outro ado do seu medo – George Addair.");
		frases.put (103,"Nós podemos facilmente perdoar uma criança que tem medo do escuro; a tragédia real da vida é quando os homens têm medo da luz – Platão.");
		frases.put (104,"Comece onde você está. Use o que você tem. Faça o que puder – Arthur Ashe.");
		frases.put (105,"Quando eu tinha 5 anos de idade, minha mãe me disse que a felicidade era a chave para a vida. Quando eu fui para a escola, eles me perguntaram o que eu queria ser quando crescesse. Eu escrevi ‘feliz’. Eles me disseram que eu não entendi a tarefa, e eu disse a eles que eles não entendiam a vida – John Lennon.");
		frases.put (106,"Caia 7 vezes. Levante-se 8 – Provérbio japonês.");
		frases.put (107,"Quando a porta da felicidade se fecha, outra se abre, mas muitas vezes olhamos tanto tempo para a porta fechada que não vemos que outra foi aberta para nós – Helen Keller.");
		frases.put (108,"Tudo tem beleza. Mas nem todos podem ver – Confúcio.");
		frases.put (109,"Como é maravilhoso que ninguém precise esperar um momento antes de começar a melhorar o mundo – Anne Frank.");
		frases.put (110,"Quando eu deixar de ser o que sou, eu irei me tornar o que poderia ser – Lao Tzu.");
		frases.put (111,"A vida não é medida pelo número de respirações que damos, mas pelos momentos que nos tiram a respiração – Maya Angelou.");
		frases.put (112,"A felicidade não é algo pronto. Ela vem de suas próprias ações – Dalai Lama.");
		frases.put (113,"Em primeiro lugar, tenha um ideal prático e definitivo; uma meta, um objetivo. Em segundo lugar, disponha dos meios necessários para atingir os seus fins; sabedoria, dinheiro, materiais e métodos. Em terceiro lugar, ajuste todos os seus meios para esse fim – Aristóteles.");
		frases.put (114,"Se os ventos não vão servir, leve os remos – Provérbio americano.");
		frases.put (115,"Você não pode cair se não subir. Mas não há nenhuma alegria em viver toda a sua vida na terra – Desconhecido.");
		frases.put (116,"Devemos crer que somos dotados de alguma coisa, e que essa coisa, deve ser atingida a qualquer custo – Marie Curie.");
		frases.put (117,"Muitos de nós não estamos vivendo nossos sonhos porque estamos vivendo nossos medos- Les Brown.");
		frases.put (118,"Os desafios são o que tornam a vida interessante e superá-los é o que dá sentido à vida – Joshua J. Marinho.");
		frases.put (119,"Se você quiser se levantar, levante outra pessoa – Booker T. Washington.");
		frases.put (120,"Fiquei impressionado com a urgência de fazer. Saber não é suficiente; devemos aplicar. Estar disposto não é o suficiente; devemos fazer – Leonardo Da Vinci.");
		frases.put (121,"Limitações vivem apenas em nossas mentes. Mas se usarmos nossa imaginação, nossas possibilidades tornam-se ilimitadas – Jamie Paolinetti.");
		frases.put (122,"Você toma sua vida em suas próprias mãos e o que acontece? Uma coisa terrível, ninguém para colocar a culpa – Erica Jong.");
		frases.put (123,"O que é o dinheiro? Um homem de sucesso levanta pela manhã e vai para cama à noite. E no meio, faz o que quer fazer – Bob Dylan.");
		frases.put (124,"Eu não falhei no teste. Eu só encontrei 100 maneiras de fazer errado – Benjamin Franklin.");
		frases.put (125,"Para ter sucesso, o seu desejo de sucesso deve ser maior do que o seu medo do fracasso – Bill Cosby.");
		frases.put (126,"Uma pessoa que nunca cometeu um erro, nunca tentou nada de novo – Albert Einstein.");
		frases.put (127,"A pessoa que diz que não pode ser feito não deve interromper a pessoa que está fazendo – Provérbio chinês.");
		frases.put (128,"Não há engarrafamentos ao longo da milha extra – Roger Staubach.");
		frases.put (129,"Nunca é tarde demais para ser o que você poderia ter sido – George Eliot.");
		frases.put (130,"Você se torna o que você acredita – Oprah Winfrey.");
		frases.put (131,"Eu preferiria morrer de paixão do que de tédio – Vincent Van Gogh.");
		frases.put (132,"Um homem verdadeiramente rico é aquele cujos filhos correm para seus braços quando suas mãos estão vazias- Autor desconhecido.");
		frases.put (133,"Não é o que você faz para os seus filhos, mas o que você os ensinou a fazer por si mesmos, que irá torna-los serem humanos bem sucedidos – Ann Landers.");
		frases.put (134,"Se você deseja que seus filhos acabem bem, gaste o dobro de tempo com eles, e metade do dinheiro – Abigail Van Buren.");
		frases.put (135,"Construa seus próprios sonhos, ou alguém vai contratá-lo para construir os seus – Farrah Gray.");
		frases.put (136,"As batalhas que contam não são apenas as medalhas de ouro. As lutas dentro de si, as batalhas invisíveis dentro de todos nós, é o que vale a pena- Jesse Owens.");
		frases.put (137,"A educação custa dinheiro. Mas, em seguida, o mesmo acontece com a ignorância – Sir Claus Moser.");
		frases.put (138,"Tenho aprendido ao longo dos anos que, quando a mente está pronta, isso diminui o medo – Rosa Parks.");
		frases.put (139,"Não importa se você vai devagar, tanto quanto importa o fato de você não parar – Confúcio.");
		frases.put (140,"Se você pode olhar para o que tem na vida, você sempre vai ter mais. Se você olhar para o que não tem, nunca terá o suficiente – Oprah Winfrey.");
		frases.put (141,"Lembre-se que não conseguir o que você quer é algumas vezes um lance de sorte – Dalai Lama.");
		frases.put (142,"Você não pode deixar de usar a criatividade. Quanto mais você usa, mais você tem – Maya Angelou.");
		frases.put (143,"Sonhe grande e se atreva a falhar – Norman Vaughan.");
		frases.put (144,"Nossas vidas começam a terminar no dia em que nos calamos sobre as coisas que importam – Martin Luther King Jr.");
		frases.put (145,"Faça o que você puder, onde você estiver, com o que você tem – Teddy Roosevelt.");
		frases.put (146,"Se você faz o que sempre fez, vai ter o que sempre teve – Tony Robbins.");
		frases.put (147,"Sonhar, afinal, é uma forma de planejamento – Gloria Steinem.");
		frases.put (148,"É o seu lugar no mundo; é a sua vida. Vá em frente e faça tudo o que puder com ela, e torne-a a vida que você quer viver – Mae Jemison.");
		frases.put (149,"Você pode ficar desapontado se falhar, mas você está condenado se não tentar – Beverly Sills.");
		frases.put (150,"Lembre-se que ninguém pode fazer você se sentir inferior sem o seu consentimento – Eleanor Roosevelt.");
		frases.put (151,"A vida é o que fazemos dela, sempre foi, e sempre será – Moisés.");
		frases.put (152,"A questão não é quem vai me deixar; mas sim, quem vai me impedir – Ayn Rand.");
		frases.put (153,"Quando tudo parece estar indo contra você, lembre-se que o avião decola contra o vento, não a favor dele – Henry Ford.");
		frases.put (154,"Não são os anos de sua vida que contam. É a vida em seus anos – Abraham Lincoln.");
		frases.put (155,"Mude seus pensamentos e você muda seu mundo – Norman Vicent Peale.");
		frases.put (156,"Escreva algo que valha a pena ler, ou faça alguma coisa que valha a pena escrever – Benjamin Franklin.");
		frases.put (157,"Nada é impossível, a própria palavra diz ‘eu sou possível’ [i’m possible, em inglês] – Audrey Hepburn.");
		frases.put (158,"A única maneira de fazer um excelente trabalho é amar o que você faz – Steve Jobs.");
		frases.put (159,"Se você pode sonhar, você pode conseguir – Zig Ziglar.");		
	}
	
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

		ServerSocket servidor = new ServerSocket(12345);
		
		Socket cliente = null;
		
		while(true){
			cliente = servidor.accept();
			
			PrintStream escreveNoCliente = new PrintStream(cliente.getOutputStream());
			Scanner ouvirCliente = new Scanner(cliente.getInputStream());
			
			String pergunta = ouvirCliente.nextLine();
			
			System.out.println(pergunta);
			
			int escolha =  Integer.parseInt(pergunta);
			String texto;
			String hashTexto = null;
			
			if (frases.containsKey(escolha)) {
				texto = frases.get(escolha);
				
				MessageDigest algoritmo = MessageDigest.getInstance("md5");
				
				algoritmo.update(texto.getBytes(), 0, texto.length());
			
				hashTexto = (new BigInteger(1, algoritmo.digest()).toString(16));
				
			} else {
				texto = "VOCÊ NÃO TEM FRASE!!!";
			}
			
			escreveNoCliente.println(texto);
			escreveNoCliente.println(hashTexto);
			
		}
		
	}
}

import soundry2 from '../imgs/SOUNDRY 2 sem fundo.png'
import details from '../imgs/Details.svg'
import image8 from '../imgs/image 8.png'
import image12 from '../imgs/image 12.png'
import image13 from '../imgs/image 13.png'
import image15 from '../imgs/image 15.png'
import details1 from '../imgs/Details_1.svg'
import ellipse32 from '../imgs/Ellipse 32.svg'
import ellipse33 from '../imgs/Ellipse 33.svg'
import image1 from '../imgs/image 1.png'
import image3 from '../imgs/image 3.png'
import image4 from '../imgs/image 4.png'
import soundryallwhite1 from '../imgs/SOUNDRY ALL WHITE 1.png'
import facebookLogo from '../imgs/FacebookLogo.svg'
import twitterLogo from '../imgs/TwitterLogo.svg'
import instagramLogo from '../imgs/InstagramLogo.svg'
import linkedinLogo from '../imgs/LinkedinLogo.svg'

import '../css/dropdown.css'
import '../css/faqStyle.css'
import '../css/style.css'

// import 'https://code.jquery.com/jquery-3.6.0.js'
import '../script_faq.js'

{/* <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="js/script.js"></script> */}

function HomeSoundry() {
    return (
        <div className='body-home-soundry'>
            <html lang="pt-br">
                <head>
                    <meta charset="UTF-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <link rel="stylesheet" href="css/style.css" />
                    <link rel="stylesheet" href="css/faqStyle.css" />
                    <link rel="stylesheet" href="css/dropdown.css" />
                    <title>HOME - Soundry</title>
                </head>
                <body >
                    <header className="header_soudry">
                        <img src={soundry2} alt="" />
                        <li>
                            <a href="#artistas"> <ul>Nossos Artistas</ul> </a>
                            <a href="#avaliacao"> <ul>Avaliações</ul> </a>
                            <a href="#faq"> <ul>Perguntas frequentes</ul> </a>
                        </li>
                        <li>
                            <a href="http://localhost:3000/login"> <ul>Conecte-se</ul> </a>
                            <div className="dropdown">
                                <button className="dropbtn">Cadastre-se</button>
                                <div className="dropdown-content">
                                    <a href="http://localhost:3000/cadastro-artista">Sou Artistas </a>
                                    <a href="http://localhost:3000/cadastro-estabelecimento"> Sou Estabelecimento </a>
                                </div>
                            </div>
                        </li>
                    </header>

                    <img id="details" src={details} alt="" />
                    <img id="details_0" src={details} alt="" />

                    <div className="container">
                        <div className="imagem_background">
                            <span> Feito para <br /> quem faz </span>
                        </div>

                        <div className="blocks">
                            <div className="card">
                                <img src={image8} alt="" />
                                <span className="destaque">Busca</span>
                                <span className="informativo">Encontrar o local perfeito para seu gênero de apresentação.</span>
                            </div>
                            <div className="card">
                                <img src={image12} alt="" />
                                <span className="destaque">Respeito</span>
                                <span className="informativo">Receber a atenção e a recepção adequado por parte dos nossos parceiros.</span>
                            </div>
                            <div className="card">
                                <img src={image13} alt="" />
                                <span className="destaque">Qualidade</span>
                                <span className="informativo">Ter acesso à uma boa estrutura para sua apresentação.</span>
                            </div>
                            <div className="card">
                                <img src={image15} alt="" />
                                <span className="destaque">Segurança</span>
                                <span className="informativo">Poder garantir sua rotina de apresentações e manter seu público sólido.</span>
                            </div>
                        </div>
                        <img id="details_1" src={details1} alt="" />
                        <img id="details_2" src={ellipse32} alt="" />

                        <div className="artists" id="artistas">
                            <div id="text_artists">
                                <span id="title">Artistas</span>
                                <span>Veja um pouco dos nossos artistas</span>
                            </div>

                            <div className="box_artists">
                                <div className="box">
                                    <img src={image1} alt="" />
                                    <h2>Cantores</h2>
                                    <span>Nossos cantores parceiros poderão se apresentar em restaurantes selecionados para atender seu público-alvo. </span>
                                </div>

                                <div className="box">
                                    <img src={image3} alt="" />
                                    <h2>Stand Up</h2>
                                    <span>Seu objetivo é trazer risos pra boca do povo? Conosco você encontra o espaço perfeito para contruir suas piadas. </span>
                                </div>

                                <div className="box">
                                    <img src={image4} alt="" />
                                    <h2>Mágicos</h2>
                                    <span>Aqui, seus truques e ilosões serão apreciados pelos mais diversos tipos de pessoas, alcançando desde crianças até adultos interessados</span>
                                </div>
                            </div>
                        </div>

                        <div className="avaliacoes" id="avaliacao">
                            <span id="title"> Avaliações</span>
                            <div className="person">
                                <div className="left"></div>
                                <div className="right">
                                    <span id="comentario">
                                        “Sempre buscamos dar oportunidades pras mais belas vozes do nosso país.
                                        Agora, com Soundry, sinto que estamos mais perto do que nunca de encontrarmos
                                        nossos maiores talentos”</span>
                                    <p> <b> Ricardo</b>, dono do Dono's</p>
                                </div>
                            </div>
                        </div>
                        <img id="details_3" src={details1} alt="" />
                        <img id="details_4" src={ellipse33} alt="" />

                        <div className="questions_faq" id="faq">

                            <span id="title">FAQ</span>

                            <section className="faq-one">
                                <div className="container gap">
                                    <div className="accordion-grp" data-grp-name="faq-accordion">
                                        <div className="accordion">
                                            <div className="accordion-inner">
                                                <div className="accordion-title">
                                                    <h4>“Posso escolher o estilo do local que vou tocar?”</h4>
                                                </div>
                                                <div className="accordion-content">
                                                    <div className="inner">
                                                        <p>
                                                            Oferecemos uma série de filtros para que os nossos clientes escolham de acordo
                                                            com suas principais características para retornarmos os melhores resultados
                                                            no momento da pesquisa.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div className="accordion">
                                            <div className="accordion-inner">
                                                <div className="accordion-title">
                                                    <h4>“Vou ser pago?”</h4>
                                                </div>
                                                <div className="accordion-content">
                                                    <div className="inner">
                                                        <p>
                                                            O estabelecimento ficará responsável por remunerar
                                                            ou não o artista. Tudo isso você saberá antes de se
                                                            apresentar, e disponibilzaremos todas as informações
                                                            pra vocês antes de qualquer confirmação.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div className="accordion">
                                            <div className="accordion-inner">
                                                <div className="accordion-title">
                                                    <h4>“Posso levar minha banda junto?”</h4>
                                                </div>
                                                <div className="accordion-content">
                                                    <div className="inner">
                                                        <p>
                                                            Trabalhamos com vários tipos de estabelecimentos, cada um suporta
                                                            uma quantidade de artistas, confirme a quantidade de integrantes
                                                            nas informações do estabelecimento escolhido antes de realizar
                                                            uma solicitação de apresentação.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div className="accordion">
                                            <div className="accordion-inner">
                                                <div className="accordion-title">
                                                    <h4>“Como vou saber se os locais que busco estão próximos?”</h4>
                                                </div>
                                                <div className="accordion-content">
                                                    <div className="inner">
                                                        <p>
                                                            Utilizamos tecnologia de ponta! Oferecemos um serviço de geolocalização
                                                            que exibe os melhores resultados da pesquisa de acordo com a sua localização
                                                            ou endereço.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                        <img id="details_5" src={details1} alt="" />
                        <img id="details_6" src={details1} alt="" />

                    </div>

                    <footer>
                        <img src={soundryallwhite1} alt="" />
                        <div className="social_media">
                            <div className="box_footer borders"> <a href="https://www.facebook.com/">        <img src={facebookLogo} alt="" />  </a> </div>
                            <div className="box_footer borders"> <a href="https://twitter.com/i/flow/login"> <img src={twitterLogo} alt="" />   </a> </div>
                            <div className="box_footer borders"> <a href="https://www.instagram.com/accounts/login/">       <img src={instagramLogo} alt="" /> </a> </div>
                            <div className="box_footer">         <a href="https://www.linkedin.com/login/pt"><img src={linkedinLogo} alt="" />  </a> </div>
                        </div>
                        <span>Copyright © 2022 - UNLOCK</span>
                    </footer>

                </body>
            </html>
        </div>
    );
}

export default HomeSoundry;

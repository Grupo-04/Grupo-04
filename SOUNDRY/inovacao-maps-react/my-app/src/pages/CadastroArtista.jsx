import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200 laranja.png'
import ImagemSombraDireita from '../imgs/Rectangle glass laranja.png'
import ImagemDireita from '../imgs/Saly-12 Cadastro Artista.png'
import LinhasCirculo from '../imgs/decoration laranja.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

import "../css/style_pagina.css"
import "../css/style_formulario.css"

function CadastroArtista() {

    const [nome, setNome] = useState('');
    const [telefone, setTelefone] = useState('');
    const [cpf, setCpf] = useState('');
    const [estilo, setEstilo] = useState('');
    const [banda, setBanda] = useState(false);
    const [integrantes, setIntegrantes] = useState(1);
    const [tipo, setTipo] = useState('');
    const [nome_artistico, setNomeArtistico] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    
    const handleNome = (e) => {
        setNome(e.target.value)
    }

    const handleTelefoe = (e) => {
        setTelefone(e.target.value)
    }

    const handleCpf = (e) => {
        setCpf(e.target.value)
    }
    
    const handleEstilo = (e) => {
        setEstilo(e.target.value)
    }
    
    const handleBanda = (e) => {
        setBanda(e.target.value)
    }
    
    const handleIntegrantes = (e) => {
        setIntegrantes(e.target.value)
    }
    
    const handleTipo = (e) => {
        setTipo(e.target.value)
    }
    
    const handleNomeArtistico = (e) => {
        setNomeArtistico(e.target.value)
    }
    
    const handleEmail = (e) => {
        setEmail(e.target.value)
    }

    const handleSenha = (e) => {
        setSenha(e.target.value)
    }
    
    const navigate = useNavigate();
    const routeChange = () =>{ 
        let path = `/cadastro-endereco-artista`; 
        navigate(path);
    }

    const handleApi = () => {
        window.sessionStorage.setItem("nome", nome);
        window.sessionStorage.setItem("telefone", telefone);
        window.sessionStorage.setItem("cpf", cpf);
        window.sessionStorage.setItem("estilo", estilo);
        window.sessionStorage.setItem("grupo", banda);
        window.sessionStorage.setItem("qtdIntegrantes", integrantes);
        window.sessionStorage.setItem("tipo", tipo);
        window.sessionStorage.setItem("nome_artistico", nome_artistico);
        window.sessionStorage.setItem("email", email);
        window.sessionStorage.setItem("senha", senha);
        routeChange()
    }

    return (
        <>
            <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lato" />
            <div className="pagina">
                <div className="div-esquerda">
                    <div className="logo">
                        <img src={Logo} alt="Logo do servico Soundry" />
                    </div>
                    <img src={SetaVoltar} alt="" className="seta-voltar" />
                    <div className="formulario-login">
                        <div className='titulo-login'>
                            <h2>Cadastre-se</h2>
                            <img src={LinhaLaranja} alt="" />
                        </div>

                        <div>
                            <div className="div_input_formulario">
                                <label for="nome" className="texto">Nome</label>
                                <input id="nome" value={nome} onChange={handleNome} className="input_formulario" type="text" placeholder="Escreva seu nome" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="telefone" className="texto">Telefone</label>
                                <input id="telefone" value={telefone} onChange={handleTelefoe} className="input_formulario" type="text" placeholder="() 00000-0000" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="cpf" className="texto">CPF</label>
                                <input id="cpf" value={cpf} onChange={handleCpf} className="input_formulario" type="text" placeholder="00.000.000/0000-00" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="genero" className="texto">Gênero</label>
                                <input id="genero" value={estilo} onChange={handleEstilo} className="input_formulario" type="text" placeholder="Escreva seu genero" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="integrantes" className="texto">Quantidade de integrantes</label>
                                <input id="integrantes" value={integrantes} onChange={handleIntegrantes} className="input_formulario" type="text" placeholder="Digite a quantidade de artistas suportados" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="tipo" className="texto">Tipo de arte</label>
                                <input id="tipo" value={tipo} onChange={handleTipo} className="input_formulario" type="text" placeholder="Digite o seu tipo de arte" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="nome_artistico" className="texto">Nome artistico</label>
                                <input id="nome_artistico" value={nome_artistico} onChange={handleNomeArtistico} className="input_formulario" type="text" placeholder="Digite seu nome artistico" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="email" className="texto">E-mail</label>
                                <input id="email" value={email} onChange={handleEmail} className="input_formulario" type="text" placeholder="Escreva seu e-mail" />
                            </div>
                            <div className="div_input_formulario">
                                <label for="senha" className="texto">Senha</label>
                                <input id="senha" value={senha} onChange={handleSenha} className="input_formulario" type="password" placeholder="Escreva sua senha" />
                            </div>
                            <div className="button">
                                <button onClick={handleApi}>Próximo Passo</button>
                            </div>
                            <div className="footer-botao">
                                <p className="cadastrar">Já tem cadastro?</p>
                                <p className="cadastrar">Clique aqui e começe já</p>
                            </div>
                        </div>
                    </div>
                    <p className="copywrite">© 2022 Soundry. Todos os direitos reservados</p>
                </div>
                <div className="div-direita">
                    <div className="titulo-pagina">
                        <p>Entre agora para a revolução das apresentações artisticas</p>
                    </div>
                    <img src={ImagemFundoDireitra} alt="" className="imagem-fundo" />
                    <img src={LinhasCirculo} alt="" className="linhas-circulo" />
                    <img src={ImagemSombraDireita} alt="" className="imagem-sombra" />
                    <img src={ImagemDireita} alt="" className="imagem-direita-celular" />
                </div>
            </div>

            {/* <div className='endereco-pagina'>
            <EnderecoArtista/>
        </div> */}
        </>
    );
}

export default CadastroArtista;
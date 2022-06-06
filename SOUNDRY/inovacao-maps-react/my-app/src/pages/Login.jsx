import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200.png'
import ImagemSombraDireita from '../imgs/Rectangle glass.png'
import ImagemDireita from '../imgs/Saly-7 Login.png'
import LinhasCirculo from '../imgs/decoration.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import { useState } from 'react';
import api from "../api/api";
import { useNavigate } from 'react-router-dom';

import '../css/style_formulario.css'
import '../css/style_pagina.css'

function Login(){

    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');

    const handleEmail = (e) =>{
        setEmail(e.target.value)
    }

    const handleSenha = (e) =>{
        setSenha(e.target.value)
    }

    const navigate = useNavigate();
    const routeChange = (path) =>{  
        navigate(path);
    }

    const handleApi = () =>{
        api.get('/grupo-artista', {
            params:{
                email: email,
                senha: senha
            }
        })
        .then(result=>{
            let status = result.status
            if (status == 200) {
                routeChange('/estabelecimentos')
            }
        })
        .catch(error =>{
            alert("Email/senha inválidos!")
        })
    }

    return (
        <>
            <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lato" />
            <div className="pagina">
                <div className="div-esquerda">
                    <div className="logo">
                        <img src={Logo} alt="Logo do servico Soundry"/>
                    </div>
                    
                    <img src={SetaVoltar} alt="" className="seta-voltar-login"/>
                    <div className="formulario-login">
                        <div className='titulo-login'>
                            <h2>Login</h2>
                            <img src={LinhaLaranja} alt="" />
                        </div>

                        <div>
                            <div className="div_input_formulario">
                                <label for="email" className="texto">E-mail</label>
                                <input id="email" value={email} onChange={handleEmail} name='email' className="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="senha" className="texto">Senha</label>
                                <input id="senha" value={senha} onChange={handleSenha} name='senha' className="input_formulario" type="password" placeholder="Escreva sua senha"/>
                            </div>
                            <div className="button">
                                <button onClick={handleApi}>Entrar</button>
                            </div>
                            <p className="cadastrar">Não é parte do time ainda? Cadastre-se</p>
                        </div>
                    </div>
                    <p className="copywrite">© 2022 Soundry. Todos os direitos reservados</p>
                </div>
                <div className="div-direita">
                    <div className="titulo-pagina">
                        <p>Bem vindo de volta!</p>
                        <p>Estamos muito felizes por ter você conosco</p>
                    </div>
                    <img src={ImagemFundoDireitra} alt="" className="imagem-fundo"/>
                    <img src={LinhasCirculo} alt="" className="linhas-circulo"/>
                    <img src={ImagemSombraDireita} alt="" className="imagem-sombra"/>
                    <img src={ImagemDireita} alt="" className="imagem-direita-comprimento"/>
                </div>
            </div>
        </>
    );
}

export default Login;

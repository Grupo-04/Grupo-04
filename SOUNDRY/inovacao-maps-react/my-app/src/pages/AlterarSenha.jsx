import { useState } from 'react';
import api from "../api/api";
import { useNavigate } from 'react-router-dom';

function AlterarSenha() {

    const [email, setEmail] = useState('');
    const [codigo, setCodigo] = useState('');
    const [senha, setSenha] = useState('');

    const handleEmail = (e) =>{
        setEmail(e.target.value)
    }

    const handleCodigo = (e) =>{
        setCodigo(e.target.value)
    }

    const handleSenha = (e) =>{
        setSenha(e.target.value)
    }

    const navigate = useNavigate();
    const routeChange = (path) =>{  
        navigate(path);
    }

    const handleApi = () =>{
        api.put('/grupo-artista/alterar-senha', null, { 
            params:{
                emailRecebido: email,
                codigoRecebido: codigo,
                novaSenha: senha
            }
        })
        .then(result=>{
            let status = result.status
            if (status == 201) {
                alert("Senha alterada com sucesso!")
                routeChange('/login')
            }
        })
        .catch(error =>{
            alert("Dados inválidos!")
        })
    }

    return (
        <>
            <div>
                <div className="div_input_formulario">
                    <label for="email" className="texto">E-mail</label>
                    <input id="email" value={email} onChange={handleEmail} name='email' className="input_formulario" type="text" placeholder="Escreva seu e-mail" />
                </div>
                <div className="div_input_formulario">
                    <label for="codigo" className="texto">Código</label>
                    <input id="codigo" value={codigo} onChange={handleCodigo} name='codigo' className="input_formulario" type="text" placeholder="Escreva seu código" />
                </div>
                <div className="div_input_formulario">
                    <label for="senha" className="texto">Nova Senha</label>
                    <input id="senha" value={senha} onChange={handleSenha} name='senha' className="input_formulario" type="password" placeholder="Escreva sua nova senha" />
                </div>
                <div className="button">
                    <button onClick={handleApi}>Alterar</button>
                </div>
                <p className="cadastrar">Não é parte do time ainda? Cadastre-se</p>
            </div>
        </>
    );
}

export default AlterarSenha;

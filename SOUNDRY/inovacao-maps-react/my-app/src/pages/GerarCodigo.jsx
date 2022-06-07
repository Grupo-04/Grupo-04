import { useState } from 'react';
import api from "../api/api";
import { useNavigate } from 'react-router-dom';

function GerarCodigo() {

    const [email, setEmail] = useState('');

    const handleEmail = (e) => {
        setEmail(e.target.value)
    }

    const navigate = useNavigate();
    const routeChange = () => {
        navigate("/alterar-senha");
    }

    const handleApi = () => {
        api.get('/grupo-artista/enviar-codigo-artista', {
            params: {
                email: email
            }
        })
            .then(result => {
                let status = result.status
                if (status === 200) {
                    // routeChange('/estabelecimentos')
                    alert("Email enviado para: " + email)
                }
            })
            .catch(error => {
                let status = error.response.status
                if (status === 404) {
                    alert("E-mail não encontrado!")
                }
            })
    }

    return (
        <>
            <div>
                <div className="div_input_formulario">
                    <label for="email" className="texto">E-mail</label>
                    <input id="email" value={email} onChange={handleEmail} name='email' className="input_formulario" type="text" placeholder="Escreva seu e-mail" />
                </div>
                <div className="button">
                    <button onClick={handleApi}>Envia código</button>
                </div>
                <div className="button">
                    <button onClick={routeChange}>Já recebi meu código!</button>
                </div>
                <p className="cadastrar">Não é parte do time ainda? Cadastre-se</p>
            </div>
        </>
    );
}

export default GerarCodigo;

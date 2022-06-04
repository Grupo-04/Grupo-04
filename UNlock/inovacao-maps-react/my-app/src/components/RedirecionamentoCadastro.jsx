import "../css/style_formulario.css"
import "../css/style_redirecionamento_cadastro.css"

function RedirecionamentoCadastro(){
    return (
        <div className="div-fundo-borda">
            <h1>Bem Vindo!</h1>

            <h3>Como você gostaria de se cadastrar?</h3>

            <div class="button">
                <button type="submit">Artista</button>
            </div>
            <div class="button">
                <button type="submit">Estabelecimento</button>
            </div>
        </div>
    );
}

export default RedirecionamentoCadastro;
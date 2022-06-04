import estabelecimentoImg from './imgs/estabelecimento.png'
import heartVazio from './imgs/Heart.png'
import blueHeart from './imgs/Heart_preenchido_blue.png'


function TableEstabelecimento(props) {
    var count = 0;
    function curtir() {
        var heart = document.getElementById("id_heart");
        var list = [blueHeart, heartVazio]
        heart.src = list[count]
        count++;
        if (count > 1) {
            count = 0;
        }
    }
    return (
        <div id="estabelecimento" className="estabelecimento">
            <div className="foto_estabelecimento">
                <img src={estabelecimentoImg} alt="" />
            </div>
            <div className="descricao_estabelecimento">
                <h1>{props.nome}</h1>
                <div className="green_bar"></div>
                <div className="span_descricao">
                    <span>
                        {props.avgNota} ⭐⭐⭐⭐⭐ (46) - {props.tipo}<br />
                        {props.cidade}, {props.bairro}, {props.logradouro}, 849<br />
                        {/* Aberto - Fecha às 23:00<br />
                        Refeição no local - Viagem - Entrega */}
                    </span>
                </div>
            </div>
            <div className='div_heart'>
                <img id="id_heart" onClick={curtir} className="heart" src={heartVazio} alt="Imagem de coração para curtir estabelecimento" />
            </div>
        </div>
    );
}

export default TableEstabelecimento;
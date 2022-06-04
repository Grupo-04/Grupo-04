import MapMarker from './MapMarker';
import api from './api';
import api_geo_map from './api_geo_map';
import { useEffect, useState } from "react";
import TableEstabelecimento from './TableEstabelecimento';

// function Teste(enderecos) {

//     const [estabelecimentosGeo, setEstabelecimentosGeo] = useState([]);

//     var obj = {};
//     var lista_lat_lng = [];
//     for (let i = 0; i < enderecos.length; i++) {
//         api_geo_map.get(`json?address=${enderecos[i]}&key=AIzaSyC-I-SNvLtWt194E_I57f8T-lOJABy0fvs`).then((respostaGeo) => {
//             // console.log(`"Resposta ${i}: "`,respostaGeo)
//             // console.log(respostaGeo.data.results[0].geometry.location.lat)
//             // console.log(respostaGeo.data.results[0].geometry.location.lng)
//             // setEstabelecimentosGeo(respostaGeo.data)
//             obj = {
//                 lat : respostaGeo.data.results[0].geometry.location.lat,
//                 lng : respostaGeo.data.results[0].geometry.location.lng
//             }
//             lista_lat_lng.push(obj)
//         })
//     }
//     return lista_lat_lng
// }


function Estabelecimentos() {
    var lista_lat_lng = []
    
    const [estabelecimentos, setEstabelecimentos] = useState([]);
    
    useEffect(() => {
        api.get("estabelecimento/listar").then((resposta) => {
            // console.log(resposta)
            setEstabelecimentos(resposta.data)
        })
    }, [])
    
    // useEffect(() => {
        estabelecimentos.map((estabelecimentoDaVez) => (
            api_geo_map.get(`json?address=${estabelecimentoDaVez.endereco.cidade}&key=AIzaSyC-I-SNvLtWt194E_I57f8T-lOJABy0fvs`).then((respostaGeo) => {
                lista_lat_lng.push(respostaGeo.data.results[0].geometry.location.lat)
                lista_lat_lng.push(respostaGeo.data.results[0].geometry.location.lng)
            })
        ))
    // }, [])
    console.log("LISTA LAT LONG: ", lista_lat_lng)

    return (
        <>
            <div className="container_avaliacao_disponibilidade">
                <div className="inside_container_avaliacao_disponibilidade">

                    <select className="select_avaliacao" name="name_select_avaliacao" id="id_select_avaliacao">
                        <option value="0">Avaliação</option>
                    </select>
                    <select className="select_disponibilidade" name="name_select_disponibilidade"
                        id="id_select_disponibilidade">
                        <option value="0">Disponibilidade</option>
                    </select>

                </div>
            </div>

            <div className="container">
                <div className="container_estabelecimento">

                    {
                        estabelecimentos.map((estabelecimentoDaVez) => (
                                <TableEstabelecimento nome={estabelecimentoDaVez.nome} avgNota={estabelecimentoDaVez.avgNota}
                                    tipo={estabelecimentoDaVez.tipo}
                                    cidade={estabelecimentoDaVez.endereco.cidade} bairro={estabelecimentoDaVez.endereco.bairro}
                                    logradouro={estabelecimentoDaVez.endereco.logradouro} />
                        ))
                    }
                    
                </div>

                <div className="container_mapa">

                    {/* <MapMarker listaLatLong={lista_lat_long}/> */}
                    <MapMarker />

                </div>

            </div>
        </>
    );
}

export default Estabelecimentos;

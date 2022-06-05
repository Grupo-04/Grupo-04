import avatar1 from '../imgs/avatar1.png';
import imgComent1 from '../imgs/img-coment1.png';
import imgComent2 from '../imgs/img-coment2.png';

function Avaliacao() {
    return (
        <>
        <br />
            <h5 class="avaliacao-h5">Avaliações</h5>
            <div class="avaliacao-geral">
                <br />
                <br />
                <br />
                <div class="avaliacao-individual">
                    <div class="autor-comentario">
                        <img src={avatar1} alt="foto-de-perfil" />
                        <span>Ferdinanda</span>
                        <br />
                        <span class="data-coment">março 2022</span>
                    </div>
                    <br />

                    <div class="comentario">
                        <span>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Delectus hic ipsum facilis adipisci! Quibusdam dolor, vel
                            natus ea vitae officiis quas sequi alias fugiat sint non
                            nesciunt eos aspernatur consequatur?</span>

                        <br />
                        <div class="fotos-coment">
                            <img src={imgComent1} alt="foto-anexa" class="img-coment1" />
                            <img src={imgComent2} alt="foto-anexa" class="img-coment2" />
                        </div>

                    </div>
                </div>

                <div class="avaliacao-individual">
                    <div class="autor-comentario">
                        <img src={avatar1} alt="foto-de-perfil" />
                        <span>Ferdinanda</span>
                        <br />
                        <span class="data-coment">março 2022</span>
                    </div>
                    <br />

                    <div class="comentario">
                        <span>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Delectus hic ipsum facilis adipisci! Quibusdam dolor, vel
                            natus ea vitae officiis quas sequi alias fugiat sint non
                            nesciunt eos aspernatur consequatur?</span>

                        <br />
                        <div class="fotos-coment">
                            <img src={imgComent1} alt="foto-anexa" class="img-coment1" />
                            <img src={imgComent2} alt="foto-anexa" class="img-coment2" />
                        </div>

                    </div>
                </div>

                <div class="avaliacao-individual">
                    <div class="autor-comentario">
                        <img src={avatar1} alt="foto-de-perfil" />
                        <span>Ferdinanda</span>
                        <br />
                        <span class="data-coment">março 2022</span>
                    </div>
                    <br />

                    <div class="comentario">
                        <span>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Delectus hic ipsum facilis adipisci! Quibusdam dolor, vel
                            natus ea vitae officiis quas sequi alias fugiat sint non
                            nesciunt eos aspernatur consequatur?</span>

                        <br />
                        <div class="fotos-coment">
                            <img src={imgComent1} alt="foto-anexa" class="img-coment1" />
                            <img src={imgComent2} alt="foto-anexa" class="img-coment2" />
                        </div>

                    </div>
                </div>
            </div>
        </>
    );
}

export default Avaliacao;
import logo from '../imgs/SOUNDRY 2.png'
import home from '../imgs/home.png'
import userQtdBoneco from '../imgs/user-3-line (1).png'
import lupa from '../imgs/lupa.png'
import notificationIcon from '../imgs/notification_normal.png'
import userImg from '../imgs/user.png'

function Header() {
    return (
        <>
            <header className="header">
                <div className="div_logo">
                    <img className="logo_img" src={logo} alt="" />
                </div>
                <div className="div_pesquisa">

                    <div className="box">
                        <img className="home_img" src={home} alt="Imagem de casa" />
                        <div>
                            <span>
                                Local:<br />

                            </span>
                        </div>
                        <select className="select_local" name="" id="">
                            <option value=""></option>
                            <option value="">Exemplo2</option>
                            <option value="">Exemplo3</option>
                        </select>
                    </div>

                    <div className="box">
                        <input id="id_input_date" className="input_date" type="date" />
                    </div>

                    <div className="box">
                        <img src={userQtdBoneco} alt="Imagem de pessoa para indicar quantidade" />
                        <div className="box2">
                            Qtd de pessoas:
                            <input id="id_input_number" className="input_number" type="number" />
                        </div>
                    </div>

                    <div className="box">
                        <img className="lupa_img" src={lupa} alt="" />
                    </div>

                </div>
                <div className="div_usuario">
                    <img className="notification_icon" src={notificationIcon} alt="" />
                    <img className="icon_user" src={userImg} alt="" />
                    <select className="select_usuario" name="" id="">
                        <option value="">Gerald Smith</option>
                        <option value="">Editar perfil</option>
                        <option value="">Sair</option>
                    </select>
                </div>
            </header>
        </>
    );
}

export default Header;

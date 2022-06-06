import logo from '../imgs/soundry.png';
import face from '../imgs/face.png';
import inst from '../imgs/inst.png';
import twt from '../imgs/twt.png';
import link from '../imgs/link.png';

function Footer(){
    return(
        <>
        <div class="footer">
        <img src={logo} alt="" class="logo-soundry"/>

        <div class="contato">
            <img src={face} alt="logo-facebook" class="icone"/>
            <div class="barrinha"></div>
            <img src={inst} alt="logo-instagram" class="icone"/>
            <div class="barrinha"></div>
            <img src={twt} alt="logo-twitter" class="icone"/>
            <div class="barrinha"></div>
            <img src={link} alt="logo=linkedIn" class="icone"/>
        </div>

        <span>Copyright © 2022 - UNLOCK</span>

    </div>
        </>
    );
}

export default Footer;
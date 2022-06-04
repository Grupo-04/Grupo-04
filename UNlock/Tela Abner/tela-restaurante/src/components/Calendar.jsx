import imgSeta1 from '../imgs/left-arrow.png'
import imgSeta2 from '../imgs/right-arrow.png'
import script from '../script'
 

function Calendar() {

    return (
        <>
            <br />
                <h5>Selecione o período de shows</h5>
                <br/>
                    <div class="div-calendarios">
                        <span class="dia-inicial-final">Dia Inicial até Dia Final</span>
                        <br />
                        <div class="calendario-esquerda">
                            <div class="container2 flex">
                                <div class="calendar">
                                    <div class="month flex">
                                        <img class="prev" src={imgSeta1} alt="" />
                                        <div class="content">
                                            <h1>MAY</h1>

                                        </div>
                                        <img class="next" src={imgSeta2} alt="" />
                                    </div>
                                    <div class="weekdays flex">
                                        <div>Seg</div>
                                        <div>Ter</div>
                                        <div>Qua</div>
                                        <div>Qui</div>
                                        <div>Sex</div>
                                        <div>Sab</div>
                                        <div>Dom</div>
                                    </div>
                                    <div class="days flex">
                                        <div class="previous-days">26</div>
                                        <div class="previous-days">27</div>
                                        <div class="previous-days">28</div>
                                        <div class="previous-days">29</div>
                                        <div class="previous-days">30</div>
                                        <div class="previous-days">31</div>
                                        <div>1</div>
                                        <div class="today">11</div>
                                        <div>31</div>
                                        <div class="next-days">1</div>
                                        <div class="next-days">2</div>
                                        <div class="next-days">3</div>
                                        <div class="next-days">4</div>
                                        <div class="next-days">5</div>
                                    </div>
                                </div>
                            </div>
                            <script src={script}></script>
                        </div>
                    </div>
                    
                </>
                );
}

                export default Calendar;
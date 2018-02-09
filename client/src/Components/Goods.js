import {HideCont} from "./HideCont";
import React, {Component} from "react";

export function ifNull(category) {
    let temp = category;
    if (temp === undefined) {
        temp = "-";
        return temp;
    }
    else return category;
}

let calc = 0;

export default class Goods extends Component {

    constructor(props) {
        super(props);
        this.state = {
            good: this.props.good,
            deleteItem: this.props.deleteItem,
            visible: false,
            targetGood:{
                target: "",
                calc: calc,
            }
        };
    }

    enter(){
        calc++;
        if(calc % 2 !== 0){
            this.setState({
                visible: true,
            });
        }
    }

    leave(){
        calc++;
        if(calc % 2 === 0){
            this.setState({
                visible: false,
            });
        }
    }

    render() {
        return (
            <div className="Cont-box">
                <div className="Cont" onMouseEnter={this.enter.bind(this)} onMouseLeave={this.leave.bind(this)}>
                    <p className='Cont-name-price'>{this.state.good.name}</p>
                    <img src={"data:image/gif;base64," + this.state.good.productPhotos[0].largePhoto} alt=''/>
                    <p className='Cont-name-price'>Price: ${this.state.good.listPrice}</p>
                    {
                        this.state.visible ? <HideCont good={this.state.good} visible={this.state.visible} deleteItem={this.state.deleteItem}/> : null
                    }
                </div>
            </div>
        )
    }
}
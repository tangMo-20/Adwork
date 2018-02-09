import React, {Component} from 'react';
import '.././App.css';
import {PostNew} from "./GetJSON";

let obj = {};

export default class AddNew extends Component {

    constructor(props) {
        super(props);
        this.state = {
            res: [],
            name: '',
            price: '',
            weight: '',
            color: '',
            size: '',
            style: '',
            class: '',
            line: '',
            number: '',
        }
    };

    input(event){
        switch(event.target.id){
            default: {
                break;
            }
            case "Name": {
                this.setState({name: (event.target.value)});
                break;
            }
            case "Price": {
                this.setState({price: (event.target.value)});
                break;
            }
            case "Weight": {
                this.setState({weight: (event.target.value)});
                break;
            }
            case "Color": {
                this.setState({color: (event.target.value)});
                break;
            }
            case "Size": {
                this.setState({size: (event.target.value)});
                break;
            }
            case "Number": {
                this.setState({number: (event.target.value)});
                break;
            }
            case "Style": {
                this.setState({style: (event.target.value)});
                break;
            }
            case "Class": {
                this.setState({class: (event.target.value)});
                break;
            }
            case "Line": {
                this.setState({line: (event.target.value)});
                break;
            }
        }
    }

    add(){
        obj.name = this.state.name;
        obj.productNumber = this.state.number;
        obj.finishedGoodsFlag = null;
        obj.color = this.state.color;
        obj.listPrice = this.state.price;
        obj.productSize = this.state.size;
        obj.productWeight = this.state.weight;
        obj.productLine = this.state.line;
        obj.productClass = this.state.class;
        obj.productStyle = this.state.style;
        obj.productPhotos = null;
        PostNew(obj);
    };

    render() {
        return (
            <div className="App-add-cont">
                <h2 className="App-title">Fill the fields below to add new good</h2>
                <input type="text" id="Name" className="App-add" placeholder="Name" value={this.state.name} onInput={this.input.bind(this)}/>
                <input type="text" id="Price" className="App-add" placeholder="Price" value={this.state.price} onInput={this.input.bind(this)}/>
                <input type="text" id="Weight" className="App-add" placeholder="Weight" value={this.state.weight} onInput={this.input.bind(this)}/>
                <input type="text" id="Color" className="App-add" placeholder="Color" value={this.state.color} onInput={this.input.bind(this)}/>
                <input type="text" id="Size" className="App-add" placeholder="Size" value={this.state.size} onInput={this.input.bind(this)}/>
                <input type="text" id="Number" className="App-add" placeholder="Number" value={this.state.number} onInput={this.input.bind(this)}/>
                <input type="text" id="Style" className="App-add" placeholder="Style" value={this.state.style} onInput={this.input.bind(this)}/>
                <input type="text" id="Class" className="App-add" placeholder="Class" value={this.state.class} onInput={this.input.bind(this)}/>
                <input type="text" id="Line" className="App-add" placeholder="Line" value={this.state.line} onInput={this.input.bind(this)}/>
                <input type="button" className="App-add Button" value="Add new good" onClick={this.add.bind(this)}/>
            </div>
        )
    }
}
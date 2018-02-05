import React, { Component } from 'react';
import '.././App.css';
import {Menu} from './Menu';
import {GetInStock, GetTopFive, PostSearch} from "./GetJSON";

class CatalogFunc extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: "",
            searchVal: '',
            goods: [],
        };
    }

    Input(event){
        const req = (event.target.value);//.toLowerCase();
        this.setState({
            searchVal: req,
        });
    }

    Search(){
        PostSearch(this.state.searchVal).then(data => {
            this.setState({
                goods: data,
            });
        });
            this.setState({
                title: 'Goods by your request:'
            });
        console.log(this.state.goods);
    };

    ShowTopFive(){
        GetTopFive().then(data => {
            this.setState({
                goods: data,
            });
        });
            this.setState({
                title: 'The most popular:'
            });
        console.log(this.state.goods);
    };

    ShowInStock(){
        GetInStock().then(data => {
            this.setState({
                goods: data,
            });
        });
            this.setState({
                title: 'Goods in stock:'
            });
        console.log(this.state.goods);
    };

    render() {
        return (
            <div>
                <input type="text" className="App-search" placeholder="Search for goods" id="search" onInput={this.Input.bind(this)}/>;
                <input type="button" className="App-search Button" value="Search" onClick={this.Search.bind(this)}/>;
                <input type="button" className="App-search Button" value="Show top five" onClick={this.ShowTopFive.bind(this)}/>;
                <input type="button" className="App-search Button" value="Show in stock" onClick={this.ShowInStock.bind(this)}/>;
                <h1 className="App-title" id="catalog-title">{this.state.title}</h1>
                <Menu goods={this.state.goods} onClick={this.props.OnContClick}/>
            </div>
        )
    }
}

export default CatalogFunc;
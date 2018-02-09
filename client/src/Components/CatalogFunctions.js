import React, { Component } from 'react';
import {GetInStock, GetTopFive, PostDeleteItem, PostSearch} from "./GetJSON";
import {Catalog} from "./Catalog";
import AddNew from "./AddNew";
import {Menu} from "./Menu";
import TernarComponent from "./TernarComponent";

let calc = 0;

export default class CatalogFunctions extends Component {

    constructor(props) {
        super(props);
        this.state = {
            catalogTitle: "",
            searchValue: '',
            goods: [],
            visibility: false,
            empty: false,
            adding: false,
            deletingItemNumber: '',
        };
    }

    input(event){
        const req = (event.target.value);
        this.setState({
            searchValue: req,
        });
    }

    search(){
        PostSearch(this.state.searchValue).then(data => {
            console.log(data);
            if(data.length === 0){
                this.setState({
                    goods: data,
                    catalogTitle: 'No goods by your request',
                    visibility: true
                });
            }
            else{
                this.setState({
                    goods: data,
                    catalogTitle: 'Goods by your request:',
                    visibility: true
                });
            }
        });
    };

    showTopFive = () => {
        GetTopFive().then(data => {
            this.setState({
                goods: data,
                catalogTitle: 'The most popular:',
                visibility: true
            });
        });
    };

    showInStock = () => {
        GetInStock().then(data => {
            this.setState({
                goods: data,
                catalogTitle: 'Goods in stock:',
                visibility: true
            });
        });
    };

    addGood = () => {
        calc++;
        if(calc % 2 !== 0){
            this.setState({
                adding: true
            });
            document.getElementById("addBut").style.backgroundColor = "grey";
        }
        else{
            this.setState({
                adding: false
            });
            document.getElementById("addBut").style.backgroundColor = "black";
        }
    };

    deleteItem = (event) => {
        let str = event.target.parentElement.getElementsByClassName("Cont-else")[6].innerHTML;
        str = str.substr(8);
        this.setState({
            deletingItemNumber: str
        });
        PostDeleteItem(this.state.deletingItemNumber);
    };

    render() {
        return (
            <div>
                <Menu input={this.input.bind(this)}
                      search={this.search.bind(this)}
                      showTopFive={this.showTopFive.bind(this)}
                      showInStock={this.showInStock.bind(this)}
                      addGood={this.addGood.bind(this)}/>
                <TernarComponent condition={this.state.adding}>
                        <AddNew />
                </TernarComponent>
                <TernarComponent condition={this.state.visibility}>
                    <Catalog goods={this.state.goods}
                             title={this.state.catalogTitle}
                             deleteItem={this.deleteItem.bind(this)}/>
                </TernarComponent>
            </div>
        )
    }
}
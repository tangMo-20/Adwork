import React from 'react';
import '.././App.css';

export const Menu = ({input, search, showTopFive, showInStock, addGood}) => {

    return (
        <div>
            <header className="App-header">
                <h1 className="App-title">Welcome to the best shop ever</h1>
            </header>
            <input type="text" className="App-search" placeholder="Search for goods" id="search" onInput={input}/>;
            <input type="button" className="App-search Button" value="Search" onClick={search}/>;
            <input type="button" className="App-search Button" value="Show top five" onClick={showTopFive}/>;
            <input type="button" className="App-search Button" value="Show in stock" onClick={showInStock}/>;
            <input type="button" id="addBut" className="App-search Button" value="Add good" onClick={addGood}/>;
        </div>
    )
};
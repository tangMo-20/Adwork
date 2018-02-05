import React, { Component } from 'react';
import './App.css';
import CatalogFunc from "./Components/CatalogFunc";

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <h1 className="App-title">Welcome to the best shop ever</h1>
                </header>
                <CatalogFunc />
            </div>
        );
    }
}

export default App;

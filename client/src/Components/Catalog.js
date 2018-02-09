import React from 'react';
import PropTypes from 'prop-types';
import Goods from "./Goods";

export const Catalog = ({goods, title, deleteItem}) => {

    Catalog.propTypes = {
        goods: PropTypes.array.isRequired,
    };

    Goods.propTypes = {
        good: PropTypes.shape({
            name: PropTypes.string.isRequired,
            listPrice: PropTypes.number.isRequired,
            productWeight: PropTypes.number.isRequired,
            color: PropTypes.string,
            productSize: PropTypes.string,
            productStyle: PropTypes.string,
            productClass: PropTypes.string,
            productLine: PropTypes.string,
            productNumber: PropTypes.string.isRequired,
        })
    };

    return (
        <div>
            <h2 className="App-title" id="catalog-title">{title}</h2>
            <div className="App-catalog">
                {
                    goods.map((good) => {
                        return <Goods good={good} key={good.id} deleteItem={deleteItem}/>;
                    })
                }
            </div>
        </div>
    )
};
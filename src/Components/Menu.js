import React from 'react';
import PropTypes from 'prop-types';
import '.././App.css';

function ifNull(category) {
    let temp = category;
    if (temp === null) {
        temp = "-";
        return temp;
    }
    else return category;
}

export const Menu = ({goods = []}) => {
    return (
        <div className="App-catalog">
            {
                goods.map((good, index) => {
                    return <Goods good={good} key={index}/>;
                })
            }
        </div>
    )
};

const Goods = ({good}) =>
    <div className="Cont">
        <p className='Cont-name-price'>{good.name}</p>
        <img src={"data:image/gif;base64," + good.productPhotos[0].largePhoto} alt=''/>
        <p className='Cont-name-price'>Price: ${ifNull(good.listPrice)}</p>
        <p className='Cont-else'>Weight: {ifNull(good.productWeight)}</p>
        <div>
            <span className='Cont-else'>Color: {ifNull(good.color)}</span>
            <span className='Cont-else'>Size: {ifNull(good.productSize)}</span>
        </div>
        <div>
            <span className='Cont-else'>Style: {ifNull(good.productStyle)}</span>
            <span className='Cont-else'>Class: {ifNull(good.productClass)}</span>
            <span className='Cont-else'>Line: {ifNull(good.productLine)}</span>
        </div>
        <p className='Cont-else'>Number: {ifNull(good.productNumber)}</p>
    </div>;

Menu.propTypes = {
    goods: PropTypes.array.isRequired
};

Goods.propTypes = {
    good: PropTypes.shape({
        name: PropTypes.string.isRequired,
        //largePhoto: PropTypes.string.isRequired,
        listPrice: PropTypes.number.isRequired,
        productWeight: PropTypes.number.isRequired,
        color: PropTypes.string.isRequired,
        productSize: PropTypes.string.isRequired,
        productStyle: PropTypes.string.isRequired,
        productClass: PropTypes.string.isRequired,
        productLine: PropTypes.string.isRequired,
        productNumber: PropTypes.string.isRequired,
    })
};


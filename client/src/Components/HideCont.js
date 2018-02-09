import React from "react";
import {ifNull} from "./Goods";
import '.././App.css';

export const HideCont = ({good, deleteItem}) =>
    <div visible="">
        <p className='Cont-else'>Weight: {ifNull(good.productWeight)} kg</p>
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
        <input type="button" className="Button-delete" value="Delete" onClick={deleteItem}/>
    </div>;
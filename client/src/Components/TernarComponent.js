import React, {Component} from 'react';

export default class TernarComponent extends Component {
    render() {
        return (
            this.props.condition ? <div>{this.props.children}</div> : null
        )
    }
};

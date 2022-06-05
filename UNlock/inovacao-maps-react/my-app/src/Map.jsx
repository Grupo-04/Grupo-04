import React, { Component } from 'react';
import { Map, GoogleApiWrapper } from 'google-maps-react';

const mapStyles = {
    width: '40%',
    height: '75vh',
    zIndex:'modal'
};

export class MapContainer extends Component {
    render() {
        return (
            <>

            <Map
                google={this.props.google}
                zoom={10}
                style={mapStyles}
                initialCenter={{ lat: -23.54325348796702, lng: -46.63352175796967 }}
                
            />

            </>
        );
    }
}

export default GoogleApiWrapper({
    apiKey: 'AIzaSyC-I-SNvLtWt194E_I57f8T-lOJABy0fvs'
})(MapContainer);

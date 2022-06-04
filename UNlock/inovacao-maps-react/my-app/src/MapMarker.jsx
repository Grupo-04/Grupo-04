// npm i -S @react-google-maps/api ATUAL
// npm install --save react-google-maps DEPRECATED
import React from 'react'
import { GoogleMap, useJsApiLoader } from '@react-google-maps/api';
import { Marker } from "@react-google-maps/api"

const containerStyle = {
  width: '100%',
  height: '100%'
};

// const center = { lat: props.listaLatLong[0], lng: props.listaLatLong[1] };
const center = { lat: -23.5557714, lng: -46.6395571 };

function MyComponent(props) {

  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: "AIzaSyC-I-SNvLtWt194E_I57f8T-lOJABy0fvs"
  })

  const [map, setMap] = React.useState(null)

  const onLoad = React.useCallback(function callback(map) {
    const bounds = new window.google.maps.LatLngBounds(center);
    map.fitBounds(bounds);
    setMap(map)
  }, [])

  const onUnmount = React.useCallback(function callback(map) {
    setMap(null)
  }, [])

  return isLoaded ? (
    <GoogleMap
      mapContainerStyle={containerStyle}
      center={center}
      zoom={8}
      onLoad={onLoad}
      onUnmount={onUnmount}
    >
      { /* Child components, such as markers, info windows, etc. */}

      {console.log("PROPS: ",props.listaLatLong)}

      {/* { <Marker position={{ lat: props.listaLatLong[0], lng: props.listaLatLong[1] }} /> }
      { <Marker position={{ lat: props.listaLatLong[2], lng: props.listaLatLong[3] }} /> }
      { <Marker position={{ lat: props.listaLatLong[4], lng: props.listaLatLong[5] }} /> }
      { <Marker position={{ lat: props.listaLatLong[6], lng: props.listaLatLong[7] }} /> }
      { <Marker position={{ lat: props.listaLatLong[8], lng: props.listaLatLong[9] }} /> } */}

      { <Marker position={{ lat: -23.5461258, lng: -46.3084079 }} /> }
      { <Marker position={{ lat: -22.7342864, lng: -47.6480644 }} /> }
      { <Marker position={{ lat: -23.6164434, lng: -46.567958 }} /> }
      { <Marker position={{ lat: -23.6879922, lng: -46.6251796 }} /> }
      { <Marker position={{ lat: -23.5557714, lng: -46.6395571 }} /> }

    </GoogleMap>
  ) : <></>
}

export default React.memo(MyComponent)

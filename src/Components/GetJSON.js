//import url_config from "./url_config";

export const GetTopFive = () => {
    return fetch('http://localhost:8080/get_top_five', {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        }})
        .then(function(response) {
            return response.json();
        });
};

export const GetInStock = () => {
    return fetch('http://localhost:8080/get_in_stock', {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        }})
        .then(function(response) {
            return response.json();
        });
};

export const PostSearch = (searchString) => {
    //debugger;
    //let stringif = JSON.stringify(searchRequest);
    return fetch('http://localhost:8080/search/' + searchString,{
            method: "GET",
            mode: "cors",
            // headers: {
            //     "Content-Type": "application/json",
            //     "Access-Control-Allow-Origin": "*",
            // },
            // body: {
            //     "searchString": searchString
            // },
        })
        .then(function(response){
            //console.log(response.json());
            return response.json();
        })
};

// export const GetBySearch = (searchRequest) => {
//     return fetch('http://localhost:8080/search/${searchRequest}', {
//         method: "GET",
//         mode: "cors",
//         headers: {
//             "Content-Type": "application/json",
//             "Access-Control-Allow-Origin": "*",
//         }
//     })
//         .then(function(response) {
//             console.log(response.json());
//             //return response.json();
//         });
// };

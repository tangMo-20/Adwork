export const GetTopFive = () => {
    return fetch('http://localhost:8080/get_top_five', {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        }
    })
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
        }
    })
        .then(function(response) {
            return response.json();
        });
};

export const PostSearch = (searchString) => {
    return fetch('http://localhost:8080/search/' + searchString,{
            method: "GET",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
            }
        })
        .then(function(response){
            return response.json();
        })
};

export const PostNew = (obj) => {
    return fetch('http://localhost:8080/add_new',{
        method: "POST",
        mode: "cors",
        body: JSON.stringify(obj),
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        },
    })
        .then(function(response){
            return response.json();
        })
};

export const PostDeleteItem = (deletingItemNumber) => {
    return fetch('http://localhost:8080/delete_item',{
        method: "POST",
        mode: "cors",
        body: JSON.stringify(deletingItemNumber),
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        }
    })
        .then(function(response){
            return response.json();
        })
};
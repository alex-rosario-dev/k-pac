let kpac_set_grid = new dhx.Grid("kpac-set-grid", {
    columns: [
        {
            id: "id",
            header: [{ text: "ID" }],
        },
        {
            id: "title",
            header: [{ text: "Title" }, { content: "inputFilter" }],
        },
        {
            id: "description",
            header: [{ text: "Description" }],
        }
    ],
    keyNavigation: true,
    selection: "row",
    autoWidth:true,
    editable: false,
    sortable: true,
    tooltip: false
});


function set_kPacs() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            kpac_set_grid.data.parse(this.responseText);
        } else {
            console.log("Error in Kpac Set api call");
        }
    };
    xhttp.open("GET", ctx+"/api/set/"+number, true);
    xhttp.send();
}



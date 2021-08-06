

const hostname = window.location.hostname;
let saved_in_memory_news_list = [];

function updateList(){
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    const rowDetailsColumns = {
        "class":"details-control",
        "orderable":false,
        "data":null,
        "defaultContent": ""
    }

    xhr.addEventListener("readystatechange", function() {
        if(this.readyState === 4) {
            console.log(this.responseText);
            saved_in_memory_news_list = JSON.parse(this.responseText);
            console.log(saved_in_memory_news_list);

            reloadTable("memory-news-table-area","example","50%",saved_in_memory_news_list,rowDetailsColumns);
        }
    });
    xhr.open("GET", `/list`);
    xhr.send();
}



function reloadTable(divId,tableId,tableWidth,data,optionalColumnObj){

    document.getElementById(divId).innerHTML="";
    let html = "";
    html += `<table id="${tableId}" class="display" width="${tableWidth}"></table>`;
    document.getElementById(divId).innerHTML=html;

    let tableColumns = [];
    let tempKeyList = [];
    for (let i = 0; i < data.length; i++) {
        const element = data[i];
        
        for (const key in element) {
            const value = element[key];
            if(value==null) continue;
            console.log(key);
            tempKeyList.push(key);
        }

    }
    tempKeyList = new Set(tempKeyList);
    tempKeyList = [...tempKeyList];

    for (let i = 0; i < tempKeyList.length; i++) {
        const element = tempKeyList[i];
        let tempObj = {
            "title":element,
            "data":element
        }
        if(element=="content"){
            tempObj.render = function(data){
                if(data.length>50){
                    let viewData = data.substr(0,49)+"..."
                    return viewData;
                }
            }
        }
        tableColumns.push(tempObj);
    }

    if(optionalColumnObj!=null&&optionalColumnObj!=undefined){
        tableColumns.unshift(optionalColumnObj);
    }
    

    $(document).ready(function() {
        var dt = $('#example').DataTable( {
            data: data,
            columns: tableColumns,

        } );

        $('#example tbody').on( 'click', 'tr td.details-control', function () {
            var detailRows = [];
            
            var tr = $(this).closest('tr');
            var row = dt.row( tr );
            var idx = $.inArray( tr.attr('id'), detailRows );
        
            if ( row.child.isShown() ) {
                tr.removeClass( 'details' );
                row.child.hide();
        
                // Remove from the 'open' array
                detailRows.splice( idx, 1 );
            }
            else {
                tr.addClass( 'details' );
                row.child( format( row.data() ) ).show();
        
                // Add to the 'open' array
                if ( idx === -1 ) {
                    detailRows.push( tr.attr('id') );
                }
            }
        } );

        // On each draw, loop over the `detailRows` array and show any child rows
        dt.on( 'draw', function () {
            $.each( detailRows, function ( i, id ) {
                $('#'+id+' td.details-control').trigger( 'click' );
            } );
        } );
    } );
}

function format ( d ) {
    return d.content;
}

// Create using table

const create_using_table_open = document.getElementById('create_using_table_open');
const modal_container_create_using_table = document.getElementById('modal_container_create_using_table');
const create_using_table_close = document.getElementById('create_using_table_close');
const amount_submit = document.getElementById("amount_submit");
const form_for_amount = document.getElementById("form_for_amount");
const input_amount = document.getElementById("input_amount");

create_using_table_open.addEventListener('click', () => {
    modal_container_create_using_table.classList.add("show");
    form_for_amount.classList.remove("vanish")
    input_amount.value = '';
    el1 = document.getElementById('table_created');
    if (el1 != null)
        el1.remove();
    el2 = document.getElementById('create_tabulated_function_table');
    if (el2 != null)
        el2.remove();
    el3 = document.getElementById('save_tabulated_function_table');
    if (el3 != null)
        el3.remove();
    el4 = document.getElementById('static_table_created');
    if (el4 != null)
        el4.remove();
});

create_using_table_close.addEventListener('click', () => {
    modal_container_create_using_table.classList.remove("show");
});

amount_submit.addEventListener('click', () => {
    if ((input_amount.value < 2) || !isInt(input_amount.value)) {
        alert("Incorrect amount!")
    }
    else {
            tbl  = document.createElement('table');
            tbl.style.border = '1px solid black';

            for(var i = 0; i < 2; i++){
                var tr = tbl.insertRow();
                let el, td;
                for(var j = 0; j <= input_amount.value; j++){
                        td = tr.insertCell();
                        if (i == 0 && j == 0) {
                            td.appendChild(document.createTextNode('X'));
                        }
                        else if (i == 1 && j == 0) {
                            td.appendChild(document.createTextNode('Y'));
                        }
                        else {
                            el = document.createElement('input');
                            el.value = '0';
                            el.setAttribute('type', 'number');
                            el.setAttribute('id', `input-table-${i}-${j-1}`);
                            td.appendChild(el);
                        }
                }
            }
            tbl.setAttribute('id', 'table_created')
            document.getElementById("table_create").appendChild(tbl);
            btn = document.createElement('button');
            btn.classList.add('btn');
            btn.classList.add('btn-success');
            btn.classList.add('mt-3');
            btn.setAttribute('type', 'submit');
            btn.setAttribute('id', 'create_tabulated_function_table');
            btn.textContent = "Confirm";
            document.getElementById("tabulated_function_table").appendChild(btn);
            create_tabulated_function_table = document.getElementById('create_tabulated_function_table');
            create_tabulated_function_table.addEventListener('click', () => {

                 if (table_arrays(input_amount.value)) {
                    tbl  = document.createElement('table');
                    tbl.style.border = '1px solid black';
                    for(var i = 0; i < 2; i++){
                        var tr = tbl.insertRow();
                        let el, td;
                        for(var j = 0; j <= input_amount.value; j++){
                            td = tr.insertCell();
                            if (i == 0 && j == 0) {
                                td.appendChild(document.createTextNode('X'));
                            }
                            else if (i == 1 && j == 0) {
                                td.appendChild(document.createTextNode('Y'));
                            }
                            else {
                                td.appendChild(document.createTextNode(`${document.getElementById(`input-table-${i}-${j-1}`).value}`));
                            }
                        }
                     }
                    document.getElementById('table_created').remove();
                    create_tabulated_function_table.remove();
                    tbl.setAttribute('id', 'static_table_created');
                    document.getElementById("table_create").appendChild(tbl);

                    el = document.getElementById('save_tabulated_function_table');
                        if (el != null)
                    el.remove();
                    btn = document.createElement('a');
                    btn.classList.add('btn');
                    btn.classList.add('btn-warning');
                    btn.classList.add('mt-3');
                    btn.setAttribute('href', "/WebOutput/tabfunc_1.bin");
                    btn.setAttribute('download', "tabulated_function.bin");
                    btn.textContent = "Save as";
                    btn.setAttribute('id', 'save_tabulated_function_table');
                    document.getElementById("tabulated_function_table").appendChild(btn);
                 }
                 else
                    alert("Structure of the tabulated function is broken!");
            });
        form_for_amount.classList.add("vanish");
    }
});
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
    if (input_amount.value < 2) {
        alert("Size < 2")
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
                 tbl.setAttribute('id', 'static_table_created');
                 document.getElementById("table_create").appendChild(tbl);

                 el = document.getElementById('save_tabulated_function_table');
                 if (el != null)
                    el.remove();
                 btn = document.createElement('a');
                 btn.classList.add('btn');
                 btn.classList.add('btn-warning');
                 btn.classList.add('mt-3');
                 btn.setAttribute('href', "/WebOutput/tabfunc_table.bin");
                 btn.setAttribute('download', "tabulated_function.bin");
                 btn.textContent = "Save as";
                 btn.setAttribute('id', 'save_tabulated_function_table');
                 document.getElementById("tabulated_function_table").appendChild(btn);
                 table_arrays(input_amount.value);
                 document.getElementById('table_created').remove();
                 create_tabulated_function_table.remove();
            });
        form_for_amount.classList.add("vanish");
    }
});

// Create using function

const create_using_function_open = document.getElementById('create_using_function_open');
const modal_container_create_using_function = document.getElementById('modal_container_create_using_function');
const create_using_function_close = document.getElementById('create_using_function_close');

create_using_function_open.addEventListener('click', () => {
    modal_container_create_using_function.classList.add("show");
});

create_using_function_close.addEventListener('click', () => {
    modal_container_create_using_function.classList.remove("show");
});

// Element-wise operations

const element_wise_operations_open = document.getElementById('element_wise_operations_open');
const modal_container_element_wise_operations = document.getElementById('modal_container_element_wise_operations');
const element_wise_operations_close = document.getElementById('element_wise_operations_close');

element_wise_operations_open.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.add("show");
});

element_wise_operations_close.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.remove("show");
});

// Differentiation

const differentiation_open = document.getElementById('differentiation_open');
const modal_container_differentiation = document.getElementById('modal_container_differentiation');
const differentiation_close = document.getElementById('differentiation_close');

differentiation_open.addEventListener('click', () => {
    modal_container_differentiation.classList.add("show");
});

differentiation_close.addEventListener('click', () => {
    modal_container_differentiation.classList.remove("show");
});

// Integral

const integral_open = document.getElementById('integral_open');
const modal_container_integral = document.getElementById('modal_container_integral');
const integral_close = document.getElementById('integral_close');

integral_open.addEventListener('click', () => {
    modal_container_integral.classList.add("show");
});

integral_close.addEventListener('click', () => {
    modal_container_integral.classList.remove("show");
});

// Settings

const settings_open = document.getElementById('settings_open');
const modal_container_settings = document.getElementById('modal_container_settings');
const settings_close = document.getElementById('settings_close');

settings_open.addEventListener('click', () => {
    modal_container_settings.classList.add("show");
});

settings_close.addEventListener('click', () => {
    modal_container_settings.classList.remove("show");
});

function table_arrays(amount) {
    let xValues_table = ""
    for (let i = 0; i < amount; i++) {
        xValues_table += document.getElementById(`input-table-0-${i}`).value + " ";
    }
    let yValues_table = ""
    for (let i = 0; i < amount; i++) {
        yValues_table += document.getElementById(`input-table-1-${i}`).value + " ";
    }
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {xValues_table, yValues_table}
    })
}
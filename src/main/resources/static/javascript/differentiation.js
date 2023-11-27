// Differentiation

const differentiation_open = document.getElementById('differentiation_open');
const modal_container_differentiation = document.getElementById('modal_container_differentiation');
const differentiation_close = document.getElementById('differentiation_close');

differentiation_open.addEventListener('click', () => {
    modal_container_differentiation.classList.add("show");
});

differentiation_close.addEventListener('click', () => {
    modal_container_differentiation.classList.remove("show");
    functions_clear();
    location.reload();
});

if (func_3_x != "") {
    modal_container_differentiation.classList.add("show");
    func_3_x_a = func_3_x.split(' ');
    func_3_y_a = func_3_y.split(' ');

    differ_operand_3_area = document.createElement('div');
    differ_operand_3_area.setAttribute('id', "differ_operand_3_area");

    document.getElementById('differ_op_3').appendChild(differ_operand_3_area);

    differ_operand_3_form = document.createElement('form');
    differ_operand_3_form.setAttribute('id', "differ_operand_3_form");
    differ_operand_3_area.appendChild(differ_operand_3_form);

    tbl  = document.createElement('table');
    tbl.style.border = '1px solid black';

    console.log(func_3_x_a);
    console.log(func_3_x_a.length);
    for(var i = 0; i < func_3_x_a.length; i++) {
        var tr = tbl.insertRow();
        let el, td;
        for(var j = 0; j < 2; j++){
             td = tr.insertCell();
             if (i == 0 && j == 0) {
                td.appendChild(document.createTextNode('X'));
             }
             else if (i == 0 && j == 1) {
                td.appendChild(document.createTextNode('Y'));
             }
             else {
                if (j == 0) {
                    td.appendChild(document.createTextNode(func_3_x_a[i-1]));
                }
                else {
                    el = document.createElement('input');
                    el.value = func_3_y_a[i-1];
                    el.setAttribute('type', 'number');
                    el.setAttribute('id', `operand-3-${i-1}`);
                    td.appendChild(el);
                }
            }
        }
    }
    differ_operand_3_form.setAttribute('style', "display: flex; align-items: center; justify-content: center; text-align: center;");
    operand_3_table = document.createElement('div');
    operand_3_table.setAttribute('style', "max-height: 400px; overflow-x: auto")
    differ_operand_3_form.appendChild(operand_3_table);
    operand_3_table.appendChild(tbl);

    btn = document.createElement('button');
    btn.classList.add('btn');
    btn.classList.add('btn-success');
    btn.classList.add('mt-3');
    btn.textContent = "Confirm changes";
    btn.setAttribute('style', "margin-right: 10px");
    differ_operand_3_area.appendChild(btn);
    btn.addEventListener('click', () => {
        length = func_3_x.split(' ').length;
        if (confirm_op_3(length))
            setTimeout(() => { location.reload(); }, 1000);
        });

    btn = document.createElement('a');
    btn.classList.add('btn');
    btn.classList.add('btn-warning');
    btn.classList.add('mt-3');
    btn.setAttribute('href', "/WebOutput/tabfunc_3");
    btn.setAttribute('download', "tabulated_function");
    btn.textContent = "Save as";
    differ_operand_3_area.appendChild(btn);
}

file_op_3_submit = document.getElementById("file_op_3_submit");
file_op_3_submit.addEventListener('click', () => {
    if(document.querySelector("#file_op_3").value == '') {
        console.log('No file selected');
        return;
    }
    else {
        file_3 = document.getElementById("file_op_3").value.split(/(\\|\/)/g).pop();
        $.ajax ({
                url: "/",
                type: 'POST',
                data: {file_3}
        });
        setTimeout(() => { location.reload(); }, 1000);
    }
});

confirm_differ = document.getElementById("confirm_differ");
confirm_differ.addEventListener('click', () => {
    if (func_3_x != "") {
        if (table_arrays_differ(func_3_x.split(' ').length)) {
            setTimeout(() => { location.reload(); }, 1000);
        }
    }
});

if (func_differ_x != "") {
    modal_container_differentiation.classList.add("show");
    func_differ_x_a = func_differ_x.split(' ');
    func_differ_y_a = func_differ_y.split(' ');

    differ_area = document.createElement('div');
    differ_area.setAttribute('id', "differ_area");

    document.getElementById('differ_result').appendChild(differ_area);
    differ_area.classList.add("mt-5");

    tbl  = document.createElement('table');
    tbl.style.border = '1px solid black';

    for(var i = 0; i < func_differ_x_a.length; i++) {
        var tr = tbl.insertRow();
        let el, td;
        for(var j = 0; j < 2; j++){
            td = tr.insertCell();
            if (i == 0 && j == 0) {
                td.appendChild(document.createTextNode('X'));
            }
            else if (i == 0 && j == 1) {
                td.appendChild(document.createTextNode('Y'));
            }
            else {
                if (j == 0) {
                    td.appendChild(document.createTextNode(func_differ_x_a[i-1]));
                }
                else {
                    td.appendChild(document.createTextNode(func_differ_y_a[i-1]));
                }
            }
        }
    }
    differ_area.setAttribute('style', "display: flex; align-items: center; justify-content: center; text-align: center;");
    differ_table = document.createElement('div');
    differ_table.setAttribute('style', "max-height: 400px; overflow-x: auto")
    differ_area.appendChild(differ_table);
    differ_table.appendChild(tbl);
    btn = document.createElement('a');
    btn.classList.add('btn');
    btn.classList.add('btn-warning');
    btn.classList.add('mt-3');
    btn.setAttribute('href', "/WebOutput/tabfunc_differ");
    btn.setAttribute('download', "tabulated_function-differ");
    btn.textContent = "Save as";
    differ_result.appendChild(btn);
}
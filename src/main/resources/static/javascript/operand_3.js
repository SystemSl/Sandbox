btn_operand_3_table = document.getElementById("operand_3_table");
btn_operand_3_function = document.getElementById("operand_3_function");
differentiation_op_3_close = document.getElementById("differentiation_op_3_close");
modal_container_differentiation_operand_3 = document.getElementById("modal_container_differentiation_operand_3");
differ_op_3 = document.getElementById("differ_op_3");

btn_operand_3_table.addEventListener('click', () => {
    el = document.getElementById("f3");
    if (el != null)
        el.remove();
    f3 = document.createElement('form');
    f3.setAttribute('id', "f3");
    f3.setAttribute('target', "votar");
    document.getElementById("differentiation_op_3").appendChild(f3);
    modal_container_differentiation_operand_3.classList.add("show");
    form_amount_3 = document.createElement('input');
    form_amount_3.setAttribute('type', "number");
    form_amount_3.setAttribute('placeholder', "Input amount of elements");
    form_amount_3.setAttribute('class', "form-control mb-2");
    form_amount_3.setAttribute('id', "form_amount_3");
    f3.appendChild(form_amount_3);
    form_amount_3_submit = document.createElement('button');
    form_amount_3_submit.setAttribute('type', "submit");
    form_amount_3_submit.setAttribute('class', "btn btn-success mb-2");
    form_amount_3_submit.textContent = "Confirm";
    f3.appendChild(form_amount_3_submit);
    form_amount_3_submit.addEventListener('click', () => {
        if (form_amount_3.value < 2) {
                    alert("Amount < 2");
        }
        else if (!isInt(form_amount_3.value)){
            alert("Amount should be integer");
        }
        else {
            table_form_3 = document.createElement('div');
            f3.appendChild(table_form_3);
            table_form_3.setAttribute('style', "overflow-x: auto")
            form_amount_3.classList.add("vanish");
            form_amount_3_submit.classList.add("vanish");
            tbl3  = document.createElement('table');
            tbl3.style.border = '1px solid black';

            for(var i = 0; i < 2; i++){
                var tr = tbl3.insertRow();
                let el, td;
                for(var j = 0; j <= form_amount_3.value; j++){
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
                        el.setAttribute('id', `input-table-3-${i}-${j-1}`);
                        td.appendChild(el);
                    }
                }
            }
            table_form_3.appendChild(tbl3);
            form_table_3_submit = document.createElement('button');
            form_table_3_submit.setAttribute('type', "submit");
            form_table_3_submit.setAttribute('class', "btn btn-success mb-2 mt-2");
            form_table_3_submit.textContent = "Confirm";
            f3.appendChild(form_table_3_submit);
            form_table_3_submit.addEventListener('click', () => {
                if (table_arrays3(form_amount_3.value)) {
                    setTimeout(() => { location.reload(); }, 1000);
                }
            });
        }
    });
});

btn_operand_3_function.addEventListener('click', () => {
    el = document.getElementById("f3");
    if (el != null)
        el.remove();
    f3 = document.createElement('form');
    f3.setAttribute('id', "f3");
    f3.setAttribute('target', "votar");
    document.getElementById("differentiation_op_3").appendChild(f3);
    modal_container_differentiation_operand_3.classList.add("show");
    sel  = document.createElement('select');
    sel.style.width = "300px";
    sel.setAttribute('id', "source_3");
    sel.setAttribute('class', "form-select function_alphabet mb-1");
    let opt = document.createElement('option');
    opt.setAttribute('selected', true);
    opt.textContent = funcs[0];
    opt.setAttribute('value', `${funcs[0]}`);
    sel.appendChild(opt);
    for (let i = 1; i < funcs.length; i++) {
        opt = document.createElement('option');
        opt.textContent = funcs[i];
        opt.setAttribute('value', `${funcs[i]}`);
        sel.appendChild(opt);
    }
    f3.appendChild(sel);
    xFrom_3 = document.createElement('input');
    xFrom_3.setAttribute('type', "number");
    xFrom_3.setAttribute('placeholder', "Input x1");
    xFrom_3.setAttribute('class', "form-control mb-1");
    xFrom_3.setAttribute('id', "xFrom_3");
    xFrom_3.style.width = "150px";
    f3.appendChild(xFrom_3);
    xTo_3 = document.createElement('input');
    xTo_3.setAttribute('type', "number");
    xTo_3.setAttribute('placeholder', "Input x2");
    xTo_3.setAttribute('class', "form-control mb-1");
    xTo_3.setAttribute('id', "xTo_3");
    xTo_3.style.width = "150px";
    f3.appendChild(xTo_3);
    count_3 = document.createElement('input');
    count_3.setAttribute('type', "number");
    count_3.setAttribute('placeholder', "Input count");
    count_3.setAttribute('class', "form-control mb-1");
    count_3.setAttribute('id', "count_3");
    count_3.style.width = "150px";
    f3.appendChild(count_3);
    func_submit_3 = document.createElement('button');
    func_submit_3.setAttribute('type', "submit");
    func_submit_3.setAttribute('class', "btn btn-success mb-2");
    func_submit_3.textContent = "Confirm";
    f3.appendChild(func_submit_3);
    func_submit_3.addEventListener('click', () => {
            if (count_3.value < 2) {
                alert("Count < 2");
            }
            else if (!isInt(count_3.value)){
                alert("Count should be integer");
            }
            else if (!checkUndefinedNumber(xFrom_3.value)) {
                alert("Undefined x1!")
            }
            else if (!checkUndefinedNumber(xTo_3.value)) {
                alert("Undefined x2!")
            }
            else if (xTo_3.value == xFrom_3.value) {
                alert("x1 = x2!")
            }
            else {
                document.getElementById("source_3").setAttribute('disabled', true);
                if (document.getElementById("source_3").value == "Const function") {
                    func_submit_3.classList.add("vanish");
                    xFromT_3 = document.createElement('div');
                    xFromT_3.setAttribute('class', "mb-1 h5");
                    xFromT_3.textContent = `x1: ${xFrom_3.value}`
                    f3.appendChild(xFromT_3);
                    xToT_3 = document.createElement('div');
                    xToT_3.setAttribute('class', "mb-1 h5");
                    xToT_3.textContent = `x2: ${xTo_3.value}`
                    f3.appendChild(xToT_3);
                    countT_3 = document.createElement('div');
                    countT_3.setAttribute('class', "mb-1 h5");
                    countT_3.textContent = `count: ${count_3.value}`
                    f3.appendChild(countT_3);
                    document.getElementById("xFrom_3").classList.add("vanish");
                    document.getElementById("xTo_3").classList.add("vanish");
                    document.getElementById("count_3").classList.add("vanish");
                    c_3 = document.createElement('input');
                    c_3.setAttribute('type', "number");
                    c_3.setAttribute('placeholder', "Input const");
                    c_3.setAttribute('class', "form-control mb-1 mt-1");
                    c_3.setAttribute('id', "c_3");
                    c_3.style.width = "150px";
                    f3.appendChild(c_3);
                    func_submit_3_with_c = document.createElement('button');
                    func_submit_3_with_c.setAttribute('type', "submit");
                    func_submit_3_with_c.setAttribute('class', "btn btn-success mb-2");
                    func_submit_3_with_c.textContent = "Confirm";
                    f3.appendChild(func_submit_3_with_c);
                    func_submit_3_with_c.addEventListener('click', () => {
                        if (!checkUndefinedNumber(c_3.value)) {
                            alert("Incorrect const!")
                        }
                        else {
                            function_data_with_c3();
                            setTimeout(() => { location.reload(); }, 1000);
                        }
                    });
                }
                else {
                    function_data3();
                    setTimeout(() => { location.reload(); }, 1000);
                }
            }
        });
});

differentiation_op_3_close.addEventListener('click', () => {
    modal_container_differentiation_operand_3.classList.remove("show");
});
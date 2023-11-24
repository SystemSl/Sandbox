// Create using function

const funcs = ["Square function", "Identity function", "Const function"];
funcs.sort();

const create_using_function_open = document.getElementById('create_using_function_open');
const modal_container_create_using_function = document.getElementById('modal_container_create_using_function');
const create_using_function_close = document.getElementById('create_using_function_close');

create_using_function_open.addEventListener('click', () => {
    container_for_options = document.getElementById("container_for_options");
    if (container_for_options != null)
        container_for_options.remove();
    container_for_options = document.createElement('div');
    container_for_options.setAttribute('id', "container_for_options");
    document.getElementById("form_for_create_using_function").appendChild(container_for_options);
    modal_container_create_using_function.classList.add("show");
    sel  = document.createElement('select');
    sel.style.width = "300px";
    sel.setAttribute('id', "form_for_function");
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
    container_for_options.appendChild(sel);
    xFrom = document.createElement('input');
    xFrom.setAttribute('type', "number");
    xFrom.setAttribute('placeholder', "Input x1");
    xFrom.setAttribute('class', "form-control mb-1");
    xFrom.setAttribute('id', "xFrom");
    xFrom.style.width = "150px";
    container_for_options.appendChild(xFrom);
    xTo = document.createElement('input');
    xTo.setAttribute('type', "number");
    xTo.setAttribute('placeholder', "Input x2");
    xTo.setAttribute('class', "form-control mb-1");
    xTo.setAttribute('id', "xTo");
    xTo.style.width = "150px";
    container_for_options.appendChild(xTo);
    count = document.createElement('input');
    count.setAttribute('type', "number");
    count.setAttribute('placeholder', "Input count");
    count.setAttribute('class', "form-control mb-1");
    count.setAttribute('id', "count");
    count.style.width = "150px";
    container_for_options.appendChild(count);
    form_for_create_using_function_submit = document.createElement('button');
    form_for_create_using_function_submit.setAttribute('type', "submit");
    form_for_create_using_function_submit.setAttribute('class', "btn btn-success mb-2");
    form_for_create_using_function_submit.textContent = "Confirm";
    container_for_options.appendChild(form_for_create_using_function_submit);
    form_for_create_using_function_submit.addEventListener('click', () => {
        if ((count.value < 2) || !isInt(count.value)) {
            alert("Incorrect count!")
        }
        else if (!checkUndefinedNumber(xFrom.value)) {
            alert("Undefined x1!")
        }
        else if (!checkUndefinedNumber(xTo.value)) {
            alert("Undefined x2!")
        }
        else if (xTo.value == xFrom.value) {
            alert("x1 = x2!")
        }
        else {
            document.getElementById("form_for_function").setAttribute('disabled', true);
            if (document.getElementById("form_for_function").value == "Const function") {
                form_for_create_using_function_submit.remove();
                xFromT = document.createElement('div');
                xFromT.setAttribute('class', "mb-1 h5");
                xFromT.textContent = `x1: ${xFrom.value}`
                container_for_options.appendChild(xFromT);
                xToT = document.createElement('div');
                xToT.setAttribute('class', "mb-1 h5");
                xToT.textContent = `x2: ${xTo.value}`
                container_for_options.appendChild(xToT);
                countT = document.createElement('div');
                countT.setAttribute('class', "mb-1 h5");
                countT.textContent = `count: ${count.value}`
                container_for_options.appendChild(countT);
                document.getElementById("xFrom").classList.add("vanish");
                document.getElementById("xTo").classList.add("vanish");
                document.getElementById("count").classList.add("vanish");
                c = document.createElement('input');
                c.setAttribute('type', "number");
                c.setAttribute('placeholder', "Input const");
                c.setAttribute('class', "form-control mb-1 mt-1");
                c.setAttribute('id', "c");
                c.style.width = "150px";
                container_for_options.appendChild(c);
                form_for_create_using_function_submit_with_c = document.createElement('button');
                form_for_create_using_function_submit_with_c.setAttribute('type', "submit");
                form_for_create_using_function_submit_with_c.setAttribute('class', "btn btn-success mb-2");
                form_for_create_using_function_submit_with_c.textContent = "Confirm";
                container_for_options.appendChild(form_for_create_using_function_submit_with_c);
                form_for_create_using_function_submit_with_c.addEventListener('click', () => {
                    if (!checkUndefinedNumber(c.value)) {
                        alert("Incorrect const!")
                    }
                    else {
                        function_data_with_c();
                        cT = document.createElement('div');
                        cT.setAttribute('class', "mb-1 h5");
                        cT.textContent = `const: ${document.getElementById("c").value}`
                        container_for_options.appendChild(cT);
                        document.getElementById("c").classList.add("vanish");
                        el = document.getElementById('save_tabulated_function_function');
                        if (el != null)
                            el.remove();
                        btn = document.createElement('a');
                        btn.classList.add('btn');
                        btn.classList.add('btn-warning');
                        btn.classList.add('mt-3');
                        btn.setAttribute('href', "/WebOutput/tabfunc_function.bin");
                        btn.setAttribute('download', "tabulated_function.bin");
                        btn.textContent = "Save as";
                        btn.setAttribute('id', 'save_tabulated_function_function');
                        container_for_options.appendChild(btn);
                        form_for_create_using_function_submit_with_c.remove();
                    }
                });
            }
            else {
                document.getElementById("xFrom").classList.add("vanish");
                document.getElementById("xTo").classList.add("vanish");
                document.getElementById("count").classList.add("vanish");
                xFromT = document.createElement('div');
                xFromT.setAttribute('class', "mb-1 h5");
                xFromT.textContent = `x1: ${xFrom.value}`
                container_for_options.appendChild(xFromT);
                xToT = document.createElement('div');
                xToT.setAttribute('class', "mb-1 h5");
                xToT.textContent = `x2: ${xTo.value}`
                container_for_options.appendChild(xToT);
                countT = document.createElement('div');
                countT.setAttribute('class', "mb-1 h5");
                countT.textContent = `count: ${count.value}`
                container_for_options.appendChild(countT);
                function_data();
                el = document.getElementById('save_tabulated_function_function');
                if (el != null)
                    el.remove();
                btn = document.createElement('a');
                btn.classList.add('btn');
                btn.classList.add('btn-warning');
                btn.classList.add('mt-3');
                btn.setAttribute('href', "/WebOutput/tabfunc_function.bin");
                btn.setAttribute('download', "tabulated_function.bin");
                btn.textContent = "Save as";
                btn.setAttribute('id', 'save_tabulated_function_function');
                container_for_options.appendChild(btn);
                form_for_create_using_function_submit.remove();
            }
        }
    });
});

create_using_function_close.addEventListener('click', () => {
    modal_container_create_using_function.classList.remove("show");
});
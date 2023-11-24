// Create using function

const funcs = ["Square function", "Identity function", "Three"];
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
    opt.setAttribute('value', "0");
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
        document.getElementById("form_for_function").setAttribute('disabled', true);
        xFromT = document.createElement('div');
        xFromT.setAttribute('class', "mb-1 h5");
        xFromT.textContent = `x1: ${xFrom.value}`
        container_for_options.appendChild(xFromT);
        xFrom.remove();
        xToT = document.createElement('div');
        xToT.setAttribute('class', "mb-1 h5");
        xToT.textContent = `x2: ${xTo.value}`
        container_for_options.appendChild(xToT);
        xTo.remove();
        countT = document.createElement('div');
        countT.setAttribute('class', "mb-1 h5");
        countT.textContent = `count: ${count.value}`
        container_for_options.appendChild(countT);
        count.remove();
        form_for_create_using_function_submit.remove();
    });
});

create_using_function_close.addEventListener('click', () => {
    modal_container_create_using_function.classList.remove("show");
});
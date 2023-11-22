// Create using table

const create_using_table_open = document.getElementById('create_using_table_open');
const modal_container_create_using_table = document.getElementById('modal_container_create_using_table');
const create_using_table_close = document.getElementById('create_using_table_close');

create_using_table_open.addEventListener('click', () => {
    modal_container_create_using_table.classList.add("show");
});

create_using_table_close.addEventListener('click', () => {
    modal_container_create_using_table.classList.remove("show");
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
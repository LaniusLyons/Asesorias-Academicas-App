<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });

Route::get('/', function () {
    return redirect('/home');
});

Auth::routes();

Route::get('/home', 'HomeController@index');

/// ROUTE para Materias

Route::get('/MisMaterias', 'MateriaController@get_list');

Route::post('/updateMateria/{id_tema}', ['uses' =>'MateriaController@update_detail']);

Route::post('/crearMateria', 'MateriaController@create_detail');

Route::post('/deleteMateria/{id_tema}', ['uses' =>'MateriaController@delete_detail']);

/// ROUTE para TEMAS

Route::get('/MisTemas', 'TemaController@get_list');

Route::post('/updateTema/{id_tema}', ['uses' =>'TemaController@update_detail']);

Route::post('/crearTema', 'TemaController@create_detail');

Route::post('/deleteTema/{id_tema}', ['uses' =>'TemaController@delete_detail']);

/// ROUTE para TESTS

Route::get('/MisTests', 'TestController@get_list');

Route::post('/updateTest/{id_test}', ['uses' =>'TestController@update_detail']);

Route::get('/updateStatusTest/{id_test}', ['uses' =>'TestController@update_status']);

Route::post('/crearTest', 'TestController@create_detail');

Route::post('/deleteTest/{id_test}', ['uses' =>'TestController@delete_detail']);

/// ROUTE para CONFIG

Route::get('/Config', 'ConfigController@get_page');

Route::post('/UpdateEmail', 'ConfigController@update_email');

Route::post('/UpdatePassword', 'ConfigController@update_password');

Route::post('/UpdateMessage', 'ConfigController@update_message');

Route::post('/SendPersonalMessage','ConfigController@send_personal_message');


/// ROUTES para PREGUNTAS

Route::get('/Preguntas', 'PreguntaController@home_pregunta');

Route::post('/crearPregunta', 'PreguntaController@crear_pregunta');

Route::post('/editarPregunta/{id_pregunta}', 'PreguntaController@editar_pregunta');

Route::post('/eliminarPregunta/{id_pregunta}', 'PreguntaController@eliminar_pregunta');

//ROUTES PARA API

#Route::get('temas/{id_tema}/pregunta', 'ApiTemaController@getInitialPregunta');

#Route::get('temas/{id_tema}/pregunta/', 'ApiTemaController@getExcludedPregunta');


Route::resource('temas', 'ApiTemaController',['only' => [
    'index', 'show'
]]);

Route::resource('materias', 'ApiMateriaController',['only' => [
    'index', 'show'
]]);

Route::resource('tests', 'ApiTestController',['only' => [
    'index', 'show'
]]);

Route::resource('preguntas', 'ApiPreguntaController',['only' => [
    'index', 'show'
]]);

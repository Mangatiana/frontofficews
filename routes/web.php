<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\useraController;
use App\Http\Controllers\InformationController;

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

Route::get('/', function () {
    return view('welcome');
});

//connexion
Route::post('/connect',[useraController::class,"connect"])->name("connecter");

// page login
Route::get('/login', function () {
    return view('login');
});

// insertion info
Route::post('/inserer',[InformationController::class,"insertion"])->name("inserer");

// liste info
Route::get('/listInfo',[InformationController::class,"listInfo"])->name("listInfo");

// detail info
Route::get('/about/{id}',[InformationController::class,"detail"])->name("about");

// insertion
Route::get('/insertion', function () {
    return view('insertion');
});

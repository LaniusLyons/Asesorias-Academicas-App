<?php

namespace App\Http\Controllers;

use App\User;
use App\Materia;
use App\Tema;
use App\Pregunta;
use Illuminate\Support\Facades\Auth;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $user = Auth::user();
        $user = User::find($user->id);
        $temas = null;
		$tests = null;
        $preguntas = null;
        if($user->materias()->get()->count() > 0){
            $temas = Tema::whereIn('fk_materia',$user->materias()->pluck('id')->toArray())->get();
        }
        if(!is_null($temas) && count($temas) > 0){
			$tests = Test::whereIn('fk_tema',$temas->pluck('id'))->get();
        }
		if(!is_null($tests) && count($tests) > 0){
			$preguntas = Pregunta::whereIn('fk_test',$tests->pluck('id'))->get();
		}

        $data = array(
            'count_materias'  => $user->materias()->get()->count(),
            'count_temas'   => (!$temas) ? 0 : $temas->count(),
			'count_tests'   => (!$tests) ? 0 : $tests->count(),
            'count_preguntas' => (!$preguntas) ? 0 :$preguntas->count()
        );
        return view('home')->with($data);
    }
}

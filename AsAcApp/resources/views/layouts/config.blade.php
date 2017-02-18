@extends('home')

@section('content')
@parent

@section('menu')
<div class="panel panel-danger">
  <div class="panel-heading">OPCIONES DE CUENTA</div>
  <div class="panel-body">
  	<div class="col-md-12 col-sm-12">
  	<div class="col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
  	<div class="page-header">
			<h1><small>Actualizaci&oacute;n de Email</small></h1>
	</div>
  	<form method="post" role="form">
  		<div class="col-md-12 col-sm-12 form-group row">
    		<label class=" col-md-2 col-form-label">Contraseña Actual</label>
    		<div class="col-md-10">
    			<input type="password" name="actualPass" class="form-control" required>
    		</div>
    	</div>
    	<div class="col-md-12 col-sm-12 form-group row">
    		<label class=" col-md-2 col-form-label">Email Nuevo</label>
    		<div class="col-md-10">
    			<input type="email" name="newEmail" class="form-control" required>
    		</div>
    	</div>
    	<div style="clear:both;"></div>
    	<div class="col-md-11 col-sm-11 form-group">
    	<button type="submit" class="btn btn-danger pull-right">Actualizar</button>
    	</div>
  	</form>
  	<div style="clear:both;"></div>
  	<div class="page-header">
			<h1><small>Cambio de Contraseña</small></h1>
	</div>
  	<form method="post" role="form">
  		<div class="col-md-12 col-sm-12 form-group row">
    		<label class=" col-md-2 col-form-label">Contraseña Actual</label>
    		<div class="col-md-10">
    			<input type="password" name="actualPass" class="form-control" required>
    		</div>
    	</div>
    	<div class="col-md-12 col-sm-12 form-group row">
    		<label class=" col-md-2 col-form-label">Nueva Contraseña</label>
    		<div class="col-md-10">
    			<input type="password" name="newPass" class="form-control" required pattern=".{6,}" required title="m&iacute;nimo 6 caracteres">
    		</div>
    	</div>
    	<div class="col-md-12 col-sm-12 form-group row">
    		<label class=" col-md-2 col-form-label">Repetir Nueva Contraseña</label>
    		<div class="col-md-10">
    			<input type="password" name="newPass2" class="form-control" required pattern=".{6,}" required title="m&iacute;nimo 6 caracteres">
    		</div>
    	</div>
    	<div style="clear:both;"></div>
    	<div class="col-md-11 col-sm-11 form-group">
    	<button type="submit" class="btn btn-danger pull-right">Cambiar</button>
    	</div>
  	</form>
  	</div>
  	</div>
  </div>
</div>


@stop

@stop
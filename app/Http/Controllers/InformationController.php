<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\image;
use App\Models\categorie;
use App\Models\information;
use Illuminate\Support\Facades\DB;


class InformationController extends Controller
{
    public function insertion(Request $request){
        $titre = $request->input('titre');
        $sous_titre = $request->input('sous_titre');
        $description = $request->input('description');

        $filename = '';
        if($request->hasFile('photo')){
            $image = $request->file('photo');
            $filename = time().'.'.$image->getClientOriginalName();
            $image->move(public_path('assets/images'), $filename);
        }

        $legende = $request->input('legende');
        $source = $request->input('source');
        $idCategorie = $request->input('categorie');

        $img = new image();
        $info = new information();

        $img->insertImage($filename, $legende, $source);
        
        $idLastImg = $img->selectLastIdImage();

        $info->insertInfo($titre, $sous_titre, $description, $idLastImg->idimage, $idCategorie);
        
        $categorie = new Categorie();
        $listCat = $categorie->listerCategorie();
        $succes = 'ok';
        return view("insertion", compact("listCat", "succes"));
    }

    public function listInfo(){
        $listInfo = DB::select('select * from information join image on information.idimage = image.idimage join categorie on information.idcategorie = categorie.idcategorie order by date desc');
        return view('index', ['listInfo' => $listInfo]);
    }

    public function detail($id){
        $info = DB::select('select * from information join image on information.idimage = image.idimage join categorie on information.idcategorie = categorie.idcategorie where idinf='.$id);
        return view('about', ['info' => $info]);
    }
}

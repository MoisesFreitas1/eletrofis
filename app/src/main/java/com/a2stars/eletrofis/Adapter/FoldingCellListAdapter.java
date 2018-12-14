package com.a2stars.eletrofis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a2stars.eletrofis.Model.Assunto;
import com.a2stars.eletrofis.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Assunto> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public FoldingCellListAdapter(Context context, List<Assunto> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Assunto assunto = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);


            // Fazer ligacoes
            viewHolder.nomeAssunto = (TextView) cell.findViewById(R.id.nomeAssunto);
            viewHolder.conceito = (TextView) cell.findViewById(R.id.conceito);
            viewHolder.trecho = (TextView) cell.findViewById(R.id.trecho);
            viewHolder.imagemTema = (ImageView) cell.findViewById(R.id.imagemTema);


            cell.setTag(viewHolder);
        } else {
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // Setar valores
        viewHolder.nomeAssunto.setText(assunto.getTema());
        viewHolder.conceito.setText(assunto.getConceito());
        viewHolder.trecho.setText(assunto.getTrecho());
        viewHolder.imagemTema.setImageResource(assunto.getImagem2());

        return cell;
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    private static class ViewHolder {
        //elementos do item
        ImageView imagemTema;
        TextView nomeAssunto;
        TextView conceito;
        TextView trecho;
    }
}

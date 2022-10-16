package com.example.cardgame;

public class Check {
    public <PreparedStatement> boolean isUser(String id)
    {
        boolean isDuplicate = false;
        Connection connection = lockConnection();
        String sql = "Select something from Database";


        try{
            PreparedStatement statement =  connection.prepareStatement(sql);
            if(statement != null)
            {
                statement.setString(1,id);
            }

        }

    }

}

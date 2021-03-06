CREATE DATABASE [Mock_project_G2]
GO
USE [Mock_project_G2]
GO
/****** Object:  Schema [candidate]    Script Date: 2/11/2019 11:09:15 AM ******/
CREATE SCHEMA [candidate]
GO
/****** Object:  Table [candidate].[Candidate]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Candidate](
	[candidate_id] [int] IDENTITY(1,1) NOT NULL,
	[application_date] [datetime] NULL,
	[remark] [varchar](255) NULL,
	[status] [varchar](255) NULL,
	[candidateProfile_profile_id] [int] NULL,
	[channel_channel_id] [int] NULL,
	[location_location_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[candidate_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[CandidateProfile]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[CandidateProfile](
	[profile_id] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](255) NULL,
	[cv] [varchar](255) NULL,
	[date_of_birth] [datetime] NULL,
	[email] [varchar](255) NULL,
	[foreign_language] [varchar](255) NULL,
	[full_name] [varchar](255) NULL,
	[gender] [varchar](255) NULL,
	[graduation_year] [varchar](255) NULL,
	[levels] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[skill] [varchar](255) NULL,
	[type] [varchar](255) NULL,
	[faculty_faculty_id] [int] NULL,
	[university_university_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Channel]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Channel](
	[channel_id] [int] IDENTITY(1,1) NOT NULL,
	[channel_name] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[channel_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Class]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Class](
	[class_id] [int] IDENTITY(1,1) NOT NULL,
	[class_admin_id] [int] NULL,
	[class_code] [varchar](255) NULL,
	[class_name] [varchar](255) NULL,
	[expected_end_date] [datetime] NULL,
	[expected_start_date] [datetime] NULL,
	[learning_path] [datetime] NULL,
	[planned_trainee_number] [numeric](19, 2) NULL,
	[statuz] [varchar](255) NULL,
	[subject_type] [varchar](255) NULL,
	[trainer_id] [int] NULL,
	[location_location_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[EntryTest]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[EntryTest](
	[test_id] [int] IDENTITY(1,1) NOT NULL,
	[language_result] [varchar](255) NULL,
	[language_valuator] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[result] [varchar](255) NULL,
	[technical_result] [varchar](255) NULL,
	[technical_valuator] [varchar](255) NULL,
	[test_date] [datetime] NULL,
	[times] [int] NULL,
	[candidate_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[test_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Faculty]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Faculty](
	[faculty_id] [int] IDENTITY(1,1) NOT NULL,
	[faculty_name] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[faculty_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[History]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[History](
	[histoey_id] [int] IDENTITY(1,1) NOT NULL,
	[dates] [datetime] NULL,
	[history_log] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[candidate_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[histoey_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Interview]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Interview](
	[interview_id] [int] IDENTITY(1,1) NOT NULL,
	[comments] [varchar](255) NULL,
	[date] [datetime] NULL,
	[interviewer] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[result] [varchar](255) NULL,
	[time] [int] NOT NULL,
	[candidate_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[interview_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Location]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Location](
	[location_id] [int] IDENTITY(1,1) NOT NULL,
	[location_name] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[location_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Roles]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Roles](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[University]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[University](
	[university_id] [int] IDENTITY(1,1) NOT NULL,
	[remark] [varchar](255) NULL,
	[university_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[university_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [candidate].[Users]    Script Date: 2/11/2019 11:09:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [candidate].[Users](
	[users_id] [int] IDENTITY(1,1) NOT NULL,
	[passwords] [varchar](255) NULL,
	[users_name] [varchar](255) NULL,
	[role_role_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[users_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [candidate].[Candidate] OFF
GO
SET IDENTITY_INSERT [candidate].[Candidate] ON
 
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (1, CAST(0x0000AA4100735B40 AS DateTime), NULL, N'New', 1, 1, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (2, CAST(0x0000AA4100735B40 AS DateTime), NULL, N'New', 2, 2, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (3, CAST(0x0000AA6000735B40 AS DateTime), NULL, N'New', 3, 4, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (4, CAST(0x0000AA4100735B40 AS DateTime), NULL, N'New', 4, 5, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (5, CAST(0x0000A9C900735B40 AS DateTime), NULL, N'New', 5, 5, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (6, CAST(0x0000A9C900735B40 AS DateTime), NULL, N'New', 6, 2, NULL)
GO
INSERT [candidate].[Candidate] ([candidate_id], [application_date], [remark], [status], [candidateProfile_profile_id], [channel_channel_id], [location_location_id]) VALUES (7, CAST(0x0000AA7E00735B40 AS DateTime), NULL, N'New', 7, 4, NULL)
GO
SET IDENTITY_INSERT [candidate].[Candidate] OFF
GO
SET IDENTITY_INSERT [candidate].[CandidateProfile] ON 

GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (1, N'TRANH', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\bmw_e90_deep_concave_black_helicopter_94623_1920x1080.jpg', CAST(0x0000AB3600735B40 AS DateTime), N'HaiNT53@gmail.com', N'EN', N'hai Tran', N'1', N'02/28/2019', N'220', N'No note', N'01687869017', NULL, N'Java', N'Candidate', 1, 1)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (2, N'NGUYENH', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\pier_dock_sea_dusk_shore_118549_1920x1080.jpg', CAST(0x0000AA7E00735B40 AS DateTime), N'HaiNT531@gmail.com', N'JP', N'Hai nguyen', N'1', N'02/21/2019', N'1222', N'No note', N'123123213213', NULL, N'C#', N'Candidate', 3, 4)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (3, N'HAINT', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\bmw_e90_deep_concave_black_helicopter_94623_1920x1080.jpg', CAST(0x0000AA7E00735B40 AS DateTime), N'HaiNT53@yahoo.com', N'EN', N'Nguyen Tran Hai', N'1', N'02/05/2019', N'2222', N'NO note', N'21321321321', NULL, N'.net', N'Candidate', 2, 2)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (4, N'ANNV', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\bmw_e90_deep_concave_black_helicopter_94623_1920x1080.jpg', CAST(0x0000AA7E00735B40 AS DateTime), N'An@gmail.com', N'JP', N'Nguyen Van An', N'1', N'02/06/2019', N'1236', N'NO ntoe', N'123123123213', NULL, N'Java', N'Candidate', 1, 3)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (5, N'CUONGNL', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\dawn-dusk-hd-wallpaper-36717.jpg', CAST(0x0000AA7E00735B40 AS DateTime), N'cuongML@gmail.com', N'EN', N'nguyen lien cuong', N'1', N'02/05/2019', N'2222', N'No note', N'HaiNT53', NULL, N'JAVA', N'Candidate', 4, 5)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (6, N'PHUOCDT', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\ferrari_veyron_bugatti_black_italy_red_90595_1920x1080.jpg', CAST(0x0000AA6000735B40 AS DateTime), N'Phuoc@gmail.com', N'JP', N'PhuocDT', N'1', N'02/12/2019', N'22233', N'No note', N'123123123', NULL, N'Java', N'Candidate', 6, 4)
GO
INSERT [candidate].[CandidateProfile] ([profile_id], [account], [cv], [date_of_birth], [email], [foreign_language], [full_name], [gender], [graduation_year], [levels], [note], [phone], [remark], [skill], [type], [faculty_faculty_id], [university_university_id]) VALUES (7, N'NGUYENHT', N'C:\Users\TemplateCNET\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HN_FR_JAVA_18_09_AdminBoard_G2\resources\cv\pier_dock_sea_dusk_shore_118549_1920x1080.jpg', CAST(0x0000A9E800735B40 AS DateTime), N'hai@gmail.com', N'EN', N'Hai tran nguyen', N'1', N'02/05/2019', N'333', N'No note', N'123213213', NULL, N'C#', N'Candidate', 5, 4)
GO
SET IDENTITY_INSERT [candidate].[CandidateProfile] OFF
GO
SET IDENTITY_INSERT [candidate].[Channel] ON 

GO
INSERT [candidate].[Channel] ([channel_id], [channel_name], [remark]) VALUES (1, N'FACEBOOK', N'NULL')
GO
INSERT [candidate].[Channel] ([channel_id], [channel_name], [remark]) VALUES (2, N'YOUTUBE', N'NULL')
GO
INSERT [candidate].[Channel] ([channel_id], [channel_name], [remark]) VALUES (3, N'VIETNAM.NET', N'NULL')
GO
INSERT [candidate].[Channel] ([channel_id], [channel_name], [remark]) VALUES (4, N'RUF', N'NULL')
GO
INSERT [candidate].[Channel] ([channel_id], [channel_name], [remark]) VALUES (5, N'UNIVERSITY', N'NULL')
GO
SET IDENTITY_INSERT [candidate].[Channel] OFF
GO
SET IDENTITY_INSERT [candidate].[Class] ON 

GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (1, 1, N'JAVA_18_09', N'JAVA 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(11.00 AS Numeric(19, 2)), N'In process', N'Java', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (2, 2, N'JAVA_18_19', N'JAVA 10', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(11.00 AS Numeric(19, 2)), N'In process', N'Java', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (3, 2, N'.NET_18_09', N'.NET 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(15.00 AS Numeric(19, 2)), N'In process', N'.Net', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (4, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'JS', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (5, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'C#', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (6, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'Angular', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (7, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (8, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'AI', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (9, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (10, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'Java', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (11, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (12, 1, N'JAVA_18_09', N'JAVA 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(11.00 AS Numeric(19, 2)), N'In process', N'Java', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (13, 2, N'JAVA_18_19', N'JAVA 10', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(11.00 AS Numeric(19, 2)), N'In process', N'Java', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (14, 2, N'.NET_18_09', N'.NET 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(15.00 AS Numeric(19, 2)), N'In process', N'.Net', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (15, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'JS', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (16, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'C#', 1, 1)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (17, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'Angular', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (18, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (19, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'AI', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (20, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (21, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'Java', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (22, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 3)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (23, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'JS', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (24, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'C#', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (25, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planning', N'Angular', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (26, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (27, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'AI', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (28, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (29, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'Java', 1, 2)
GO
INSERT [candidate].[Class] ([class_id], [class_admin_id], [class_code], [class_name], [expected_end_date], [expected_start_date], [learning_path], [planned_trainee_number], [statuz], [subject_type], [trainer_id], [location_location_id]) VALUES (30, 3, N'C++_18_09', N'C++ 09', CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(0x0000A9F100B1E22D AS DateTime), CAST(21.00 AS Numeric(19, 2)), N'Planned', N'C++', 1, 2)
GO
SET IDENTITY_INSERT [candidate].[Class] OFF
GO
SET IDENTITY_INSERT [candidate].[Faculty] ON 

GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (1, N'JAVA', N'NULL')
GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (2, N'.NET', N'NULL')
GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (3, N'JS', N'NULL')
GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (4, N'c++', N'NULL')
GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (5, N'TEST', N'NULL')
GO
INSERT [candidate].[Faculty] ([faculty_id], [faculty_name], [remark]) VALUES (6, N'ANGULAR', N'NULL')
GO
SET IDENTITY_INSERT [candidate].[Faculty] OFF
GO
SET IDENTITY_INSERT [candidate].[Location] ON 

GO
INSERT [candidate].[Location] ([location_id], [location_name], [remark]) VALUES (1, N'Ha Noi', N'Null')
GO
INSERT [candidate].[Location] ([location_id], [location_name], [remark]) VALUES (2, N'Da Nang', N'Null')
GO
INSERT [candidate].[Location] ([location_id], [location_name], [remark]) VALUES (3, N'Ho Chi Minh', N'Null')
GO
SET IDENTITY_INSERT [candidate].[Location] OFF
GO
SET IDENTITY_INSERT [candidate].[Roles] ON 

GO
INSERT [candidate].[Roles] ([role_id], [role_name]) VALUES (1, N'ROLE_ADMIN')
GO
INSERT [candidate].[Roles] ([role_id], [role_name]) VALUES (2, N'ROLE_MANAGER')
GO
INSERT [candidate].[Roles] ([role_id], [role_name]) VALUES (3, N'ROLE_USER')
GO
SET IDENTITY_INSERT [candidate].[Roles] OFF
GO
SET IDENTITY_INSERT [candidate].[University] ON 

GO
INSERT [candidate].[University] ([university_id], [remark], [university_name]) VALUES (1, N'NULL', N'UNETI')
GO
INSERT [candidate].[University] ([university_id], [remark], [university_name]) VALUES (2, N'NULL', N'FPT')
GO
INSERT [candidate].[University] ([university_id], [remark], [university_name]) VALUES (3, N'NULL', N'NEU')
GO
INSERT [candidate].[University] ([university_id], [remark], [university_name]) VALUES (4, N'NULL', N'HUBT')
GO
INSERT [candidate].[University] ([university_id], [remark], [university_name]) VALUES (5, N'NULL', N'BK')
GO
SET IDENTITY_INSERT [candidate].[University] OFF
GO
SET IDENTITY_INSERT [candidate].[Users] ON 

GO
INSERT [candidate].[Users] ([users_id], [passwords], [users_name], [role_role_id]) VALUES (1, N'$2a$04$GYGsaJj9l6kH2GikK6QVzO0v3sOCxt3vdkiA2/tcoSw8erI85ZYDG', N'HaiNT53', 1)
GO
INSERT [candidate].[Users] ([users_id], [passwords], [users_name], [role_role_id]) VALUES (2, N'$2a$04$GYGsaJj9l6kH2GikK6QVzO0v3sOCxt3vdkiA2/tcoSw8erI85ZYDG', N'HaiNT54', 2)
GO
INSERT [candidate].[Users] ([users_id], [passwords], [users_name], [role_role_id]) VALUES (3, N'$2a$04$GYGsaJj9l6kH2GikK6QVzO0v3sOCxt3vdkiA2/tcoSw8erI85ZYDG', N'HaiNT55', 3)
GO
SET IDENTITY_INSERT [candidate].[Users] OFF
GO
ALTER TABLE [candidate].[Candidate]  WITH CHECK ADD  CONSTRAINT [FKhwoq0ckt3d0a2jct6u7ay1v8e] FOREIGN KEY([candidateProfile_profile_id])
REFERENCES [candidate].[CandidateProfile] ([profile_id])
GO
ALTER TABLE [candidate].[Candidate] CHECK CONSTRAINT [FKhwoq0ckt3d0a2jct6u7ay1v8e]
GO
ALTER TABLE [candidate].[Candidate]  WITH CHECK ADD  CONSTRAINT [FKodfo3nku2orjev4wfa9lbt855] FOREIGN KEY([location_location_id])
REFERENCES [candidate].[Location] ([location_id])
GO
ALTER TABLE [candidate].[Candidate] CHECK CONSTRAINT [FKodfo3nku2orjev4wfa9lbt855]
GO
ALTER TABLE [candidate].[Candidate]  WITH CHECK ADD  CONSTRAINT [FKsbq4m56ia9td8nqneqje8f75t] FOREIGN KEY([channel_channel_id])
REFERENCES [candidate].[Channel] ([channel_id])
GO
ALTER TABLE [candidate].[Candidate] CHECK CONSTRAINT [FKsbq4m56ia9td8nqneqje8f75t]
GO
ALTER TABLE [candidate].[CandidateProfile]  WITH CHECK ADD  CONSTRAINT [FK5tkpdmc46ulwlkcs0uv27hnk2] FOREIGN KEY([faculty_faculty_id])
REFERENCES [candidate].[Faculty] ([faculty_id])
GO
ALTER TABLE [candidate].[CandidateProfile] CHECK CONSTRAINT [FK5tkpdmc46ulwlkcs0uv27hnk2]
GO
ALTER TABLE [candidate].[CandidateProfile]  WITH CHECK ADD  CONSTRAINT [FKs3vi9f01rssvuxi9t2q6dn7ao] FOREIGN KEY([university_university_id])
REFERENCES [candidate].[University] ([university_id])
GO
ALTER TABLE [candidate].[CandidateProfile] CHECK CONSTRAINT [FKs3vi9f01rssvuxi9t2q6dn7ao]
GO
ALTER TABLE [candidate].[Class]  WITH CHECK ADD  CONSTRAINT [FK2sku2e3bqn480mswqusb1dse1] FOREIGN KEY([location_location_id])
REFERENCES [candidate].[Location] ([location_id])
GO
ALTER TABLE [candidate].[Class] CHECK CONSTRAINT [FK2sku2e3bqn480mswqusb1dse1]
GO
ALTER TABLE [candidate].[EntryTest]  WITH CHECK ADD  CONSTRAINT [FKo6iy6x0ww44qddji9ghqokbo8] FOREIGN KEY([candidate_id])
REFERENCES [candidate].[Candidate] ([candidate_id])
GO
ALTER TABLE [candidate].[EntryTest] CHECK CONSTRAINT [FKo6iy6x0ww44qddji9ghqokbo8]
GO
ALTER TABLE [candidate].[History]  WITH CHECK ADD  CONSTRAINT [FKnlmxcsalu8lcrrrl95v0qi5fn] FOREIGN KEY([candidate_id])
REFERENCES [candidate].[Candidate] ([candidate_id])
GO
ALTER TABLE [candidate].[History] CHECK CONSTRAINT [FKnlmxcsalu8lcrrrl95v0qi5fn]
GO
ALTER TABLE [candidate].[Interview]  WITH CHECK ADD  CONSTRAINT [FKoyde1vbkshxv6uhbyqkk967ov] FOREIGN KEY([candidate_id])
REFERENCES [candidate].[Candidate] ([candidate_id])
GO
ALTER TABLE [candidate].[Interview] CHECK CONSTRAINT [FKoyde1vbkshxv6uhbyqkk967ov]
GO
ALTER TABLE [candidate].[Users]  WITH CHECK ADD  CONSTRAINT [FKm3af4f7nfb1fog6e0akiu4p66] FOREIGN KEY([role_role_id])
REFERENCES [candidate].[Roles] ([role_id])
GO
ALTER TABLE [candidate].[Users] CHECK CONSTRAINT [FKm3af4f7nfb1fog6e0akiu4p66]
GO
